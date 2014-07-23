package com.tw.wldandan.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RateTypeTest {

    @Test
    public void testWeekdayWhenLowercase() throws Exception {
        List<String> days = new ArrayList<String>();
        days.add("mon");
        days.add("tues");
        days.add("wed");
        days.add("thur");
        days.add("fri");

        for (String day : days) {
            assertThat(RateType.parseRateType(day), is(RateType.WEEKDAY));
        }
    }

    @Test
    public void testInWeekdayWhenUpperCase() throws Exception {
        List<String> days = new ArrayList<String>();
        days.add("MON");
        days.add("TUES");
        days.add("WED");
        days.add("THUR");
        days.add("FRI");

        for (String day : days) {
            assertThat(RateType.parseRateType(day), is(RateType.WEEKDAY));
        }
    }

    @Test
    public void testInWeekdayWhenMixedCase() throws Exception {
        List<String> days = new ArrayList<String>();
        days.add("MoN");
        days.add("TuES");
        days.add("WeD");
        days.add("THuR");
        days.add("FRi");

        for (String day : days) {
            assertThat(RateType.parseRateType(day), is(RateType.WEEKDAY));
        }
    }

    @Test
    public void testWeekend() throws Exception {
        List<String> days = new ArrayList<String>();
        days.add("Sat");
        days.add("SUN");
        for (String day : days) {
            assertThat(RateType.parseRateType(day), is(RateType.WEEKEND));
        }
    }
}
