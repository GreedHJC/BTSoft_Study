package kr.btsoft.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class TestDto {

    private String userId;
    private String userPw;
    private String userName;
    private int userBirth;
    private String userAddr;
    private int userHp;
    private int officeTel;
    private Date joinDay;
    private Date outDay;
    private String grade;
    private String depart;

}

