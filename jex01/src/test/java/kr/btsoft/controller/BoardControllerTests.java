package kr.btsoft.controller;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration        //@WebAppConfiguration은 Servlet의 ServletContext 의 WebApplicationContext라는 존재를 이용하기 위해서 사용
@ContextConfiguration(classes = {kr.btsoft.config.RootConfig.class, kr.btsoft.config.ServletConfig.class})
@Log4j
public class BoardControllerTests {
    @Setter(onMethod_ = {@Autowired})
    private WebApplicationContext ctx;

    private MockMvc mockMvc;    // MockMvc '가짜 MVC'

    @Before     // @Before가 적용된 메서드는 모든 테스트 전에 매번 실행되는 메서드
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void testList() throws Exception {
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
                .andReturn()
                .getModelAndView()
                .getModelMap()
        );
    }

    @Test
    public void testRegister() throws Exception {
        String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
                .param("title", "테스트 새글 제목")
                .param("content", "테스트 새글 내용")
                .param("writer", "user00")
        ).andReturn().getModelAndView().getViewName();

        log.info(resultPage);
    }

    @Test
    public void testGet() throws Exception {
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
        .param("bno", "5" ))
        .andReturn()
        .getModelAndView().getModelMap());
    }

    @Test
    public void testModify() throws Exception {

        String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
        .param("bno","6")
        .param("title", "수정된 테스트 새글 제목")
        .param("content", "수정된 테스트 새글 내용")
        .param("writer", "user00"))
                .andReturn().getModelAndView().getViewName();

        log.info(resultPage);
    }

    @Test
    public void testRemove() throws Exception{
        String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
        .param("bno", "25"))
        .andReturn().getModelAndView().getViewName();

        log.info(resultPage);
    }

}
