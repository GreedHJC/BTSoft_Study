package kr.btsoft.service;

import kr.btsoft.domain.BoardVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {kr.btsoft.config.RootConfig.class})
@Log4j
public class BoardServiceTests {
    @Setter(onMethod_ = {@Autowired} )
    private BoardService service;

    @Test
    public void testExist() {
        log.info(service);
        assertNotNull(service);
    }

    @Test
    public void testRegister() {
        BoardVO board = new BoardVO();
        board.setTitle("새로 작성하는 글test");
        board.setContent("새로 작성하는 내용 test");
        board.setWriter("newbie");

        service.register(board);

        log.info("생성된 게시물의 번호 : " + board.getBno());
    }

    @Test
    public  void testGetList() {
        service.getList().forEach(board -> log.info(board));
    }

    @Test
    public  void testGet() {
        log.info(service.get(2L));
    }

    @Test
    public void testUpdate() {
        BoardVO board = service.get(4L);

        if(board ==null){
            return;
        }

        board.setTitle("제목 수정합니다.");
        log.info("MODIFY RESULT : " + service.modify(board));
    }

    @Test
    public void testDelete(){
        log.info("REMOVE RESULT" + service.remove(4L));
    }

}
