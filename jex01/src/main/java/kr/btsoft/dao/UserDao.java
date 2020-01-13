package kr.btsoft.dao;

import kr.btsoft.vo.UserVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao {

    public int insertSignup(UserVo userVo);
    public int insertAuth(Map auth);
    public UserVo readUser(String username);
    public List<String> readAuthority(String username);
    public String readMaxofnum();
    public List<UserVo> selectUsersInfo(String keyword);

}
