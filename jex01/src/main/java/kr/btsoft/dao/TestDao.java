package kr.btsoft.dao;

import kr.btsoft.vo.TestVo;

import java.util.Map;

public interface TestDao {

    public String selectNow();

    public int insertSignup(TestVo testVo);

    public int insertAuth(Map auth);

}
