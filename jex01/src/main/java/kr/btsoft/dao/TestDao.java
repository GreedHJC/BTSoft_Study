package kr.btsoft.dao;


import kr.btsoft.dto.TestDto;
import kr.btsoft.mapper.TestMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao {

    @Autowired
    private SqlSession sqlSession;

    public String selectNow() {
        TestMapper mapper = sqlSession.getMapper(TestMapper.class);
        String test = mapper.selectNow();
        return test;
    }

    public int insertSignup(TestDto testDto) {
        TestMapper mapper = sqlSession.getMapper(TestMapper.class);
        int temp = mapper.insertSignup(testDto);

        return temp;
    }
}
