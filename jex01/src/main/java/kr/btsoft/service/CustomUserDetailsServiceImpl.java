package kr.btsoft.service;

import kr.btsoft.mapper.UserMapper;
import kr.btsoft.vo.UserDetailsVo;
import kr.btsoft.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserVo userVo = userMapper.readUser(username);

        if(userVo != null) {
            userVo.setAuthorities(makeGrantedAuthority(userMapper.readAuthority(username)));
        }
        return new UserDetailsVo(userVo);
    }

    private static List<GrantedAuthority> makeGrantedAuthority(List<String> rolse) {

        List<GrantedAuthority> list = new ArrayList<>();
//        rolse.forEach(role -> list.add(new SimpleGrantedAuthority(role)));
        for(String role : rolse) {
            list.add(new SimpleGrantedAuthority(role));
        }
        return list;

    }
}
