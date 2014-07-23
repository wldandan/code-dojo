package com.tw.wldandan.model;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HotelTest {

    @Test
    public void testHotelWithRatingAndRates() throws Exception {
        Rate regularRate = new Rate(RateType.WEEKDAY, 110, 80);
        Rate rewardRate = new Rate(RateType.WEEKEND, 90, 80);
        Hotel hotel = new Hotel("Lakewood", 3, regularRate,rewardRate);

        assertThat(hotel.getRating(), is(3));
        assertThat(hotel.getWeekdayRate().getRegularCost(), is(110));
        assertThat(hotel.getWeekdayRate().getRewardCost(), is(80));
    }
}
