package kr.btsoft.dao;


import kr.btsoft.mapper.TestMapper;
import kr.btsoft.vo.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class TestDaoImpl implements TestDao {

    @Autowired
    private TestMapper mapper;

    @Override
    public String selectNow() {

        String test = mapper.selectNow();

        return test;
    }

    @Override
    public int insertSignup(TestVo testVo) {

        int temp = mapper.insertSignup(testVo);

        return temp;
    }

    @Override
    public int insertAuth(Map auth) {

        int temp = mapper.insertAuth(auth);

        return temp;
    }
}
