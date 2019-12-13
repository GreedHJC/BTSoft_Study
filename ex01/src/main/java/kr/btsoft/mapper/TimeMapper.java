package kr.btsoft.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

    @Select("SELECT sysdate From dual")
    public String getTime();

    public String getTime2();

}
