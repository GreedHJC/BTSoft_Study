package kr.btsoft.mapper;


import kr.btsoft.vo.TestVo;

import java.util.List;
import java.util.Map;

public interface TestMapper {

    public String selectNow();
    public int insertSignup(TestVo testVo);
    public int insertAuth(Map auth);
    public TestVo readUser(String username);
    public List<String> readAuthority(String username);

}
