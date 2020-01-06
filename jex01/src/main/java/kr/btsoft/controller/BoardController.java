package kr.btsoft.controller;

import kr.btsoft.domain.BoardAttachVO;
import kr.btsoft.domain.BoardVO;
import kr.btsoft.domain.Criteria;
import kr.btsoft.domain.PageDTO;
import kr.btsoft.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Log4j
@Controller     // 스프링의 빈으로 인식하는 어노테이션
@RequestMapping("/board/*")
@AllArgsConstructor //@AllArgsConstructor 를 이용해서 생성자를 만들고 자동으로 주입(만일 생성자를 만들지않을경우는 @Setter(onMethod_ ={@Autowired})사용 해야함)
public class BoardController {
    private BoardService service;

    @GetMapping("/list")
    public void list(Criteria cri, Model model) {     //게시물의 목록을 전달해야 하므로 Model을 파라미터로 지정하고
        log.info("list : " + cri);
        model.addAttribute("list", service.getList(cri)); // 이를 통해 BoardServiceImpl 객체의 getList() 결과를 담아 전달(addAttribute)
        model.addAttribute("pageMaker", new PageDTO(cri, 123)); // pagemaker 라는 이름으로 pageDTO클래스에서 객채를 만들어서 Model에 담아줌
        int total = service.getTotal(cri);

        log.info("total :" + total);

        model.addAttribute("pageMaker", new PageDTO(cri, total));
    }

    @GetMapping("/register")
    public void register() {

    }

    @PostMapping("/register")
    public String register(BoardVO board, RedirectAttributes rttr) {

        log.info("==========================");
        log.info("register: " + board);
        if (board.getAttachList() != null) {
            board.getAttachList().forEach(attach -> log.info(attach));
        }

        log.info("==========================");
        service.register(board);
        rttr.addFlashAttribute("result", board.getBno());
        return "redirect:/board/list";
    }

    @GetMapping({"/get", "/modify"})
    public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri")Criteria cri, Model model) {
        log.info("/get or modify");
        model.addAttribute("board", service.get(bno));
    }


    @PostMapping("/modify")
    public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
        log.info("modify:" + board);

        if (service.modify(board)) {
            rttr.addFlashAttribute("result", "success");
        }

        rttr.addAttribute("pageNum", cri.getPageNum());
        rttr.addAttribute("amount", cri.getAmount());
        rttr.addAttribute("type", cri.getType());
        rttr.addAttribute("keyword", cri.getKeyword());

        return "redirect:/board/list";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam("bno") Long bno, Criteria cri, RedirectAttributes rttr) {

        log.info("remove..." + bno);
        List<BoardAttachVO> attachList = service.getAttachList(bno);
        if (service.remove(bno)) {
            // delete Attach Files
            deleteFiles(attachList);
            rttr.addFlashAttribute("result", "success");
        }
        return "redirect:/board/list" + cri.getListLink();
    }

    private void deleteFiles(List<BoardAttachVO> attachList) {

        if(attachList == null || attachList.size() == 0) {
            return;
        }

        log.info("delete attach files...................");
        log.info(attachList);

        attachList.forEach(attach -> {
            try {
                Path file  = Paths.get("C:\\upload\\"+attach.getUploadPath()+"\\" + attach.getUuid()+"_"+ attach.getFileName());
                Files.deleteIfExists(file);
                if(Files.probeContentType(file).startsWith("image")) {
                    Path thumbNail = Paths.get("C:\\upload\\"+attach.getUploadPath()+"\\s_" + attach.getUuid()+"_"+ attach.getFileName());
                    Files.delete(thumbNail);
                }
            }catch(Exception e) {
                log.error("delete file error" + e.getMessage());
            }//end catch
        });//end foreachd
    }

    @GetMapping(value = "/getAttachList",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<List<BoardAttachVO>> getAttachList(Long bno) {

        log.info("getAttachList " + bno);

        return new ResponseEntity<>(service.getAttachList(bno), HttpStatus.OK);

    }
}
