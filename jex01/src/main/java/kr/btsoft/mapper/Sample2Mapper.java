package kr.btsoft.mapper;

import org.apache.ibatis.annotations.Insert;

/**
 * description
 *
 * @author : jcHwang
 */
public interface Sample2Mapper {
    @Insert("insert into tbl_sample2 (col2) values (#{data})")
    public int insertCol2(String data);
}
