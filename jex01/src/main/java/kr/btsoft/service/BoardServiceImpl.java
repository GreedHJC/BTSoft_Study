package kr.btsoft.service;

import kr.btsoft.domain.BoardAttachVO;
import kr.btsoft.domain.BoardVO;
import kr.btsoft.domain.Criteria;
import kr.btsoft.mapper.BoardAttachMapper;
import kr.btsoft.mapper.BoardMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Service 계층 구조상 주로 비즈니스 영역을 담당하는 개체임을 표시, 작성된 어노테이션은 팾키지를 읽어 들이는 동안 처리됩니다.
@Log4j
@Service
@AllArgsConstructor //@AllArgsConstructor모든 파라미터를 이용하는 생성자를 만들어 줌
public class BoardServiceImpl implements BoardService{

    @Setter(onMethod_ = @Autowired)
    //spring 4.3이상에서 단일 파라미터를 받는 생성자의 경우에는 필요한 파라미터를 자동 주입
    private BoardMapper mapper;

    @Setter(onMethod_ = @Autowired)
    private BoardAttachMapper attachMapper;

    @Transactional
    @Override
    public void register(BoardVO board) {

        log.info("register......" + board);
        mapper.insertSelectKey(board);
        if (board.getAttachList() == null || board.getAttachList().size() <= 0) {
            return;
        }
        board.getAttachList().forEach(attach -> {
            attach.setBno(board.getBno());
            attachMapper.insert(attach);
        });
    }

    @Override
    public BoardVO get(Long bno) {
        log.info("get......" + bno);
        return mapper.read(bno);

    }

    @Transactional
    @Override
    public boolean modify(BoardVO board) {

        log.info("modify......" + board);

        attachMapper.deleteAll(board.getBno());
        boolean modifyResult = mapper.update(board) == 1;
        if (modifyResult && board.getAttachList().size() > 0) {
            board.getAttachList().forEach(attach -> {
                attach.setBno(board.getBno());
                attachMapper.insert(attach);
            });
        }
        return modifyResult;
    }

    @Override
    public boolean remove(Long bno) {
        log.info("remove...." + bno);
        attachMapper.deleteAll(bno);
        return mapper.delete(bno) == 1;
    }

    @Override
    public List<BoardVO> getList(Criteria cri) {

        log.info("get List with criteria: " + cri);
        return mapper.getListWithPaging(cri);
    }

    @Override
    public int getTotal(Criteria cri) {

        log.info("get total count");
        return mapper.getTotalCount(cri);
    }

    @Override
    public List<BoardAttachVO> getAttachList(Long bno) {
        log.info("get Attach list by bno" + bno);
        return attachMapper.findByBno(bno);
    }

    @Override
    public void removeAttach(Long bno) {
        log.info("remove all attach files");
        attachMapper.deleteAll(bno);
    }
}
