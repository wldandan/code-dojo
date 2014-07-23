package com.tw.wldandan.utils;

public class Utils {
    public static String parseDay(String day){
        return day.substring(day.indexOf("(")+1, day.indexOf(")"));
    }


}
