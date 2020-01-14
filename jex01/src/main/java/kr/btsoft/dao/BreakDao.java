package kr.btsoft.dao;

import java.util.List;
import java.util.Map;

public interface BreakDao {

    public List<Map<String,Object>> selectUserBreak(String officeNum);
    public List<Map<String,Object>> selectAllBreak();
    public void insertBreakApply(Map map);

}
