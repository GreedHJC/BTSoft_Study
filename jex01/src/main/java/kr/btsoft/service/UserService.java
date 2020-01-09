package kr.btsoft.service;


import java.util.List;

import kr.btsoft.vo.UserVo;

public interface UserService {

    public int insrtSignup(UserVo userVo);
    public UserVo selectUser(String username);
    public List<UserVo> selectUsersInfo();
}
