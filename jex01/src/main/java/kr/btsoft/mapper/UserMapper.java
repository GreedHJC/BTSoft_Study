package kr.btsoft.mapper;


import kr.btsoft.vo.UserVo;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    public String selectNow();
    public int insertSignup(UserVo userVo);
    public int insertAuth(Map auth);
    public UserVo readUser(String username);
    public List<String> readAuthority(String username);
    public String readMaxofnum();

}
