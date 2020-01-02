package kr.btsoft.service;

import kr.btsoft.domain.Criteria;
import kr.btsoft.domain.ReplyPageDTO;
import kr.btsoft.domain.ReplyVO;

import java.util.List;

/**
 * description
 *
 * @author : jkkim
 */
public interface ReplyService {
    public int register(ReplyVO vo);

    public ReplyVO get(Long rno);

    public int modify(ReplyVO vo);

    public int remove(Long rno);

    public List<ReplyVO> getList(Criteria cri, Long bno);

    public ReplyPageDTO getListPage(Criteria cri, Long bno);

}
