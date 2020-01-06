package kr.btsoft.domain;

import lombok.Data;

/**
 * description
 *
 * @author : jcHwang
 */
@Data
public class BoardAttachVO {

    private String uuid;
    private String uploadPath;
    private String fileName;
    private boolean fileType;

    private Long bno;
}
