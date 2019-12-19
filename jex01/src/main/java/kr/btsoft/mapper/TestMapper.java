package kr.btsoft.mapper;


import kr.btsoft.dto.TestDto;

public interface TestMapper {

    public String selectNow();
    public int insertSignup(TestDto testDto);
}
