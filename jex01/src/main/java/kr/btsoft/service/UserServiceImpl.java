package kr.btsoft.service;

import kr.btsoft.dao.UserDao;
import kr.btsoft.utils.OfficeNumUtil;
import kr.btsoft.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;


    //특정 예외가 발생 시 강제로 Rollback 진행
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insrtSignup(UserVo userVo) {

        userVo.setUserPw(passwordEncoder.encode(userVo.getUserPw()));
        userVo.setOfficeNum(OfficeNumUtil.maxOfficeNum(userDao.readMaxofnum()));
        userVo.setEnabled(false);

        Map<String, Object> auth = new HashMap<>();

        auth.put("userId", userVo.getUserId());
        auth.put("authority", "ROLE_USER");

        int success = userDao.insertSignup(userVo);
        userDao.insertAuth(auth);

        return success;
    }

    @Override
    public UserVo selectUser(String username) {

        UserVo userVo = userDao.readUser(username);

        return userVo;
    }

	@Override
	public List<UserVo> selectUsersInfo(String keyword) {
		List<UserVo> userList = userDao.selectUsersInfo(keyword);
		
		return userList;
	}
}
