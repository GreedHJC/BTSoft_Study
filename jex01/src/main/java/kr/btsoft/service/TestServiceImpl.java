package kr.btsoft.service;

import kr.btsoft.dao.TestDao;
import kr.btsoft.dto.TestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    public String testNow() {

        String test = testDao.selectNow();

        return test;
    }

    @Override
    public int insrtSignup(TestDto testDto) {

        int temp = testDao.insertSignup(testDto);

        return temp;
    }
}
