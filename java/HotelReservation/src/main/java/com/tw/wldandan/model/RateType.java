package com.tw.wldandan.model;

import java.util.ArrayList;
import java.util.List;

public enum RateType {
    WEEKDAY, WEEKEND;

    static RateType parseRateType(String day) throws Exception {
        List<String> weekday = new ArrayList<String>();
        weekday.add("mon");
        weekday.add("tues");
        weekday.add("wed");
        weekday.add("thur");
        weekday.add("fri");

        List<String> weekend = new ArrayList<String>();
        weekend.add("sat");
        weekend.add("sun");

        if (weekday.contains(day.toLowerCase())) {
            return RateType.WEEKDAY;
        }

        if (weekend.contains(day.toLowerCase())) {
            return RateType.WEEKEND;
        }

        throw new Exception("error week type");
    }
}