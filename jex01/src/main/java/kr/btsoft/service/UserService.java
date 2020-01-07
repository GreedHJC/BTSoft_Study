package kr.btsoft.service;


import kr.btsoft.vo.UserVo;

public interface UserService {

    public String testNow();
    public int insrtSignup(UserVo userVo);
    public UserVo selectUser(String username);

}
