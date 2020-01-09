package kr.btsoft.vo;

import kr.btsoft.vo.UserVo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.userdetails.User;

@Setter
@Getter
@ToString
public class UserDetailsVo extends User {

    private static final long serialVersionUID = 1L;
    private String ip;
    private String officeNum;

    public UserDetailsVo(UserVo testvo) {
        super(testvo.getUserId(), testvo.getUserPw(),testvo.isEnabled(),true,true,true, testvo.getAuthorities());
        this.officeNum = testvo.getOfficeNum();
    }
}