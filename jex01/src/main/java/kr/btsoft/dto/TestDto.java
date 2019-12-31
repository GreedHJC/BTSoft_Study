package kr.btsoft.dto;

import kr.btsoft.vo.TestVo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.userdetails.User;

@Setter
@Getter
@ToString
public class TestDto extends User {

    private static final long serialVersionUID = 1L;
    private String ip;

    public TestDto(TestVo testvo) {
        super(testvo.getUserId(), testvo.getUserPw(), testvo.getAuthorities());
    }
}