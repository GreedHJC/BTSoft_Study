package kr.btsoft.controller;

import kr.btsoft.domain.SampleDTO;
import kr.btsoft.domain.SampleDTOList;
import kr.btsoft.domain.TodoDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

    @RequestMapping("")
    public void basic() {
        log.info("basic..................");
    }

    @RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
    public void basicGet(){
        log.info("baSIC GET............................");
    }


    @GetMapping("/basicOnlyGet")
    public void basicGet2(){
        log.info("basic get only get......................");
    }

    @GetMapping("/ex01")
    public String ex01(SampleDTO dto){
        log.info(("" + dto));

        return "ex01";
    }

    //@RequestParam은 파라미터로 사용된 변수의 이름과 전달되는 파라미터의 이름이 다른 경우에 유용하게 사용용
    @GetMapping("/ex02")
    public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
            log.info(("name : " + name));
            log.info(("age : " + age));

            return "ex02";
        }

    @GetMapping("/ex02List")
    public String ex02List(@RequestParam("ids")ArrayList<String> ids){
        log.info("ids: " + ids);

        return "ex02List";
    }
    @GetMapping("/ex02Array")
    public String ex02Array(@RequestParam("ids") String[] ids){
        log.info("array: " + Arrays.toString(ids));

        return "ex02List";
    }
    @GetMapping("/ex02Bean")
    public String ex02Bean(SampleDTOList list){
        log.info("list dtos : " + list);

        return "ex02Bean";
    }

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
//    }

    @GetMapping("/ex03")
    public String ex03(TodoDTO todo){
        log.info("todo : " + todo);
        return "ex03";
    }

    //@ModelAttribute
    @GetMapping("/ex04")
    public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
        log.info("dto : " + dto);
        log.info("page : " + page);
        return "/sample/ex04";
    }

    @GetMapping("/ex05")
    public void ex05() {
        log.info("/ex05..............");
    }
    @GetMapping("/ex06")
    public @ResponseBody SampleDTO ex06() {
        log.info("/ex06..............");
        SampleDTO dto = new SampleDTO();
        dto.setAge(10);
        dto.setName("홍길동");

        return dto;
    }
    @GetMapping("/ex07")
    public ResponseEntity<String> ex07(){
        log.info("/ex07.................");

        // {"name" : "홍길동"}
        String msg = "{\"name\": \"홍길동\"}";

        HttpHeaders header =new HttpHeaders();
        header.add("Content-type", "application/json;charset=UTF-8");

        return new ResponseEntity<>(msg, header, HttpStatus.OK);
    }

    @GetMapping("/exUpload")
    public void exUpload() {
        log.info("/exUpload.............");
    }

    @PostMapping("/exUploadPost")
    public void exUploadpost(ArrayList<MultipartFile> files) {
        files.forEach(file -> {
            log.info("==============================================");
            log.info("name :" + file.getOriginalFilename());
            log.info("size :" + file.getSize());
        });
    }
}
