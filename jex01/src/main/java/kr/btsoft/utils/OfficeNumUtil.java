package kr.btsoft.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OfficeNumUtil {

    public static String maxOfficeNum(String readoffienum) {

        String offienum = "";
        String substring = "";
        String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");

        if(readoffienum != null) {
            substring = subMaxOfNum(readoffienum);
        } else {
            substring = "001";
        }

        offienum = simpleDateFormat.format(date).replaceAll(match, "") + substring;

        return offienum;

    }

    public static String subMaxOfNum(String maxofnum) {

        String subofnum = maxofnum.substring(6, maxofnum.length());

        return String.format("%03d",Integer.parseInt(subofnum) + 1);

    }

}
