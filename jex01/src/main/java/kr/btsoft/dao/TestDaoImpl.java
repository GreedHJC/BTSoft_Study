package kr.btsoft.dao;


import kr.btsoft.vo.TestVo;
import kr.btsoft.mapper.TestMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class TestDaoImpl implements TestDao {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public String selectNow() {

        TestMapper mapper = sqlSession.getMapper(TestMapper.class);
        String test = mapper.selectNow();

        return test;
    }

    @Override
    public int insertSignup(TestVo testVo) {

        TestMapper mapper = sqlSession.getMapper(TestMapper.class);
        int temp = mapper.insertSignup(testVo);

        return temp;
    }

    @Override
    public int insertAuth(Map auth) {

        TestMapper mapper = sqlSession.getMapper(TestMapper.class);
        int temp = mapper.insertAuth(auth);

        return temp;
    }
}
