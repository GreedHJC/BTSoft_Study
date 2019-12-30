package kr.btsoft.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SignupVo {

    private String userId;
    private String userPw;
    private char enabled;

}
