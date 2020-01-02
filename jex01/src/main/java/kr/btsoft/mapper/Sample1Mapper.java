package kr.btsoft.mapper;

import org.apache.ibatis.annotations.Insert;

/**
 * description
 *
 * @author : jcHwang
 */
public interface Sample1Mapper {
    @Insert("insert into tbl_sample1 (col1) values (#{data})")
    public int insertCol1(String data);

}
