package kr.btsoft.dao;


import kr.btsoft.mapper.UserMapper;
import kr.btsoft.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserMapper mapper;

    @Override
    public String selectNow() {

        String test = mapper.selectNow();

        return test;
    }

    @Override
    public int insertSignup(UserVo userVo) {

        int success = mapper.insertSignup(userVo);

        return success;
    }

    @Override
    public int insertAuth(Map auth) {

        int success = mapper.insertAuth(auth);

        return success;
    }

    @Override
    public String readMaxofnum() {

        String officenum = mapper.readMaxofnum();

        return officenum;
    }
}
