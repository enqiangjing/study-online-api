package com.so.studyonline.enhance;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTools {

    public static String currentDate() {
        Date date = new Date();// 获得当前的时间戳
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 定义格式
        return dateFormat.format(date);// 格式化时间
    }
}
