package kr.btsoft.service;

import kr.btsoft.dao.TestDao;
import kr.btsoft.vo.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String testNow() {

        String test = testDao.selectNow();

        return test;
    }

    //특정 예외가 발생 시 강제로 Rollback 진행
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insrtSignup(TestVo testVo) {

        testVo.setUserPw(passwordEncoder.encode(testVo.getUserPw()));
        testVo.setOfficeNum("1234");
        testVo.setUserHp(01);
        testVo.setEnabled('1');

        Map<String, Object> auth = new HashMap<>();

        auth.put("userId", testVo.getUserId());
        auth.put("officeNum", testVo.getOfficeNum());
        auth.put("authority", "ROLE_ADMIN");

        int temp = testDao.insertSignup(testVo);
        testDao.insertAuth(auth);

        return temp;
    }
}
