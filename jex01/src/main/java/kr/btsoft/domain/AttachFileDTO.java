package kr.btsoft.domain;

import lombok.Data;

/**
 * description
 *
 * @author : jcHwang
 */
@Data
public class AttachFileDTO {
    private String fileName;
    private String uploadPath;
    private String uuid;
    private boolean image;
}
