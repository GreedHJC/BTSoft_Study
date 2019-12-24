package kr.btsoft.service;

import kr.btsoft.domain.BoardVO;
import kr.btsoft.domain.Criteria;

import java.util.List;

public interface BoardService {

    public void register(BoardVO board);

    public BoardVO get(Long bno);

    public boolean modify(BoardVO board);

    public boolean remove(Long bno);

    // public List<BoardVO> getList();

    public List<BoardVO> getList(Criteria cri);

    //추가
    public int getTotal(Criteria cri);

}
