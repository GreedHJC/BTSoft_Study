package kr.btsoft.service;

import org.springframework.stereotype.Service;

/**
 * description
 *
 * @author : jcHwang
 */
@Service
public class SampleServiceImpl implements SampleService{

    @Override
    public Integer doAdd(String str1, String str2) throws Exception {
        return Integer.parseInt(str1) + Integer.parseInt(str2);
    }
}
