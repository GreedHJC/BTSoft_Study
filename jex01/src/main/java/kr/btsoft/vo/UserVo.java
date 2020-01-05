package kr.btsoft.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Date;

@Setter
@Getter
@ToString
public class UserVo {

    private String officeNum;
    private String userId;
    private String userPw;
    private String userName;
    private int userBirth;
    private String userAddr;
    private String userHp;
    private String officeTel;
    private Date joinDay;
    private Date outDay;
    private String grade;
    private String depart;
    private boolean enabled;
    private Collection<? extends GrantedAuthority> authorities;

}

