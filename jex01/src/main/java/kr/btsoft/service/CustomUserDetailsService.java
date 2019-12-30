package kr.btsoft.service;

import kr.btsoft.dto.TestDto;
import kr.btsoft.mapper.TestMapper;
import kr.btsoft.vo.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        TestVo testvo = testMapper.readUser(username);

        if(testvo != null) {
            testvo.setAuthorities(makeGrantedAuthority(testMapper.readAuthority(username)));
        }
        return new TestDto(testvo);
    }

    private static List<GrantedAuthority> makeGrantedAuthority(List<String> rolse) {

        List<GrantedAuthority> list = new ArrayList<>();
        rolse.forEach(role -> list.add(new SimpleGrantedAuthority(role)));
//        for(String role : rolse) {
//            list.add(new SimpleGrantedAuthority(role));
//        }
        return list;

    }
}
