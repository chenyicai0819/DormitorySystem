package cn.edu.guet.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {
    public static String dateTime(){
        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //System.out.println(dateFormat.format(date));
        return dateFormat.format(date);
    }
}
