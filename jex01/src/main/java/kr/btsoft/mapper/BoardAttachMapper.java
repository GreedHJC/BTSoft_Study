package kr.btsoft.mapper;

import kr.btsoft.domain.BoardAttachVO;

import java.util.List;

/**
 * description
 *
 * @author : jcHwang
 */
public interface BoardAttachMapper {

    public void insert(BoardAttachVO vo);

    public void delete(String uuid);

    public List<BoardAttachVO> findByBno(Long bno);

    public void deleteAll(Long bno);

    public List<BoardAttachVO> getOldFiles();

}
