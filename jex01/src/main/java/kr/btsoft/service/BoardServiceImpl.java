package kr.btsoft.service;

import kr.btsoft.domain.BoardVO;
import kr.btsoft.mapper.BoardMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service 계층 구조상 주로 비즈니스 영역을 담당하는 개체임을 표시, 작성된 어노테이션은 팾키지를 읽어 들이는 동안 처리됩니다.
@Log4j
@Service
@AllArgsConstructor //@AllArgsConstructor모든 파라미터를 이용하는 생성자를 만들어 줌
public class BoardServiceImpl implements BoardService{

    //spring 4.3이상에서 단일 파라미터를 받는 생성자의 경우에는 필요한 파라미터를 자동 주입
    private BoardMapper mapper;

    @Override
    public void register(BoardVO board) {
        log.info("register........." + board);
        mapper.insertSelectKey(board);
    }

    @Override
    public BoardVO get(Long bno) {
        log.info("get................" + bno);
        return mapper.read(bno);
    }

    @Override
    public boolean modify(BoardVO board) {
        log.info("modify........" + board);
        return mapper.update(board) == 1;
    }

    @Override
    public boolean remove(Long bno) {
        log.info("remove........" + bno);
        return mapper.delete(bno) == 1;
    }

    @Override
    public List<BoardVO> getList() {
        log.info("getList................");
        return mapper.getList();
    }

}
