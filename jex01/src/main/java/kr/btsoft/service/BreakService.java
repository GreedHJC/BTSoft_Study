package kr.btsoft.service;

import java.util.List;
import java.util.Map;

public interface BreakService {

    public List<Map<String,Object>> selectUserBreak(String officeNum);
    public List<Map<String,Object>> selectAllBreak();
    public void insertBreakApply(Map map);

}
