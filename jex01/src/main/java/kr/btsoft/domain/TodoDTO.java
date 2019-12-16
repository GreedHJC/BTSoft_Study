package kr.btsoft.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class TodoDTO {
    private String title;

    //@DateTimeFormat 문자열을 Date타입으로 변경
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date dueDate;

}
