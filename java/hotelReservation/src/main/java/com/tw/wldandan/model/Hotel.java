package com.tw.wldandan.model;

import com.tw.wldandan.utils.Utils;

import java.util.List;

public class Hotel {

    private final String name;
    private final int rating;
    private final Rate weekendRate;
    private final Rate weekdayRate;

    public Hotel(String name, int rating, Rate weekdayRate, Rate weekendRate) {
        this.name = name;
        this.rating = rating;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
    }

    public int getRating() {
        return rating;
    }

    public Rate getWeekendRate() {
        return weekendRate;
    }

    public Rate getWeekdayRate() {
        return weekdayRate;
    }

    public String getName() {
        return name;
    }

    public Integer getCost(CustomerType customerType, RateType rateType) throws Exception {
        Rate rate;
        if (rateType.equals(RateType.WEEKDAY))
            rate = this.getWeekdayRate();
        else{
            rate = this.getWeekendRate();
        }
        return rate.getCost(customerType);
    }

    public Integer getCostByDays(CustomerType customerType, List<String> days) throws Exception {
        Integer results = 0;
        for(String day : days){
            results += getCost(customerType, RateType.parseRateType(Utils.parseDay(day)));
        }
        return results;
    }
}
