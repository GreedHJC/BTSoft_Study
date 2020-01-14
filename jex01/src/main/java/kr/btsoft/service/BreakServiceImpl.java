package kr.btsoft.service;

import kr.btsoft.dao.BreakDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BreakServiceImpl implements BreakService {

    @Autowired
    private BreakDao breakDao;

    @Override
    public List<Map<String,Object>> selectUserBreak(String officeNum) {
        return breakDao.selectUserBreak(officeNum);
    }

    @Override
    public List<Map<String,Object>> selectAllBreak() {

        return breakDao.selectAllBreak();
    }
    
    @Override
    public void insertBreakApply(Map map) {
    	breakDao.insertBreakApply(map);
    }
}
