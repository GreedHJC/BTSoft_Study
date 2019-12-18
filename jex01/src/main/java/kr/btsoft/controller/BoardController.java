package kr.btsoft.controller;

import kr.btsoft.domain.BoardVO;
import kr.btsoft.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j
@Controller     // 스프링의 빈으로 인식하는 어노테이션
@RequestMapping("/board/*")
@AllArgsConstructor //@AllArgsConstructor 를 이용해서 생성자를 만들고 자동으로 주입(만일 생성자를 만들지않을경우는 @Setter(onMethod_ ={@Autowired})사용 해야함)
public class BoardController {
    private BoardService service;

    @GetMapping("/list")
    public void list(Model model) {     //게시물의 목록을 전달해야 하므로 Model을 파라미터로 지정하고
        log.info("list");
        model.addAttribute("list", service.getList()); // 이를 통해 BoardServiceImpl 객체의 getList() 결과를 담아 전달(addAttribute)
    }

    @GetMapping("/register")
    public void register() {

    }

    @PostMapping("/register")
    public String register(BoardVO board, RedirectAttributes rttr) {

        log.info("register: " + board);
        service.register(board);
        rttr.addFlashAttribute("result", board.getBno());
        return "redirect:/board/list";
    }

    @GetMapping({"/get", "/modify"})
    public void get(@RequestParam("bno") Long bno, Model model) {
        log.info("/get or modify");
        model.addAttribute("board", service.get(bno));
    }


    @PostMapping("/modify")
    public String modify(BoardVO board, RedirectAttributes rttr) {
        log.info("modify : " + board);

        if(service.modify(board)){
            rttr.addFlashAttribute("result", "success");
        }
        return "redirect :/board/list";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr){
        log.info("remove....." + bno);
        if(service.remove(bno)){
            rttr.addFlashAttribute("result", "success");
        }
        return "redirect:/board/list";
    }
}