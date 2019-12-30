package kr.btsoft.mapper;


import kr.btsoft.vo.TestVo;

import java.util.Map;

public interface TestMapper {

    public String selectNow();
    public int insertSignup(TestVo testVo);
    public int insertAuth(Map auth);

}
