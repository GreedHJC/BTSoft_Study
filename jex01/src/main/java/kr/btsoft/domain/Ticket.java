package kr.btsoft.domain;

import lombok.Data;

@Data
public class Ticket {
    private int tno;
    private String owner;
    private String grade;
}
