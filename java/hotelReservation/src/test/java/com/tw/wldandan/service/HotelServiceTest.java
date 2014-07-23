package com.tw.wldandan.service;

import com.tw.wldandan.model.CustomerType;
import com.tw.wldandan.model.Hotel;
import com.tw.wldandan.model.Rate;
import com.tw.wldandan.model.RateType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HotelServiceTest {

    List<Hotel> hotels = new ArrayList<Hotel>();

    @Before
    public void setUp() throws Exception {
        hotels.add(new Hotel("Lakewood", 3,
                new Rate(RateType.WEEKDAY, 110, 80),
                new Rate(RateType.WEEKEND, 90, 80)));

        hotels.add(new Hotel("Bridgewood", 4,
                new Rate(RateType.WEEKDAY, 160, 110),
                new Rate(RateType.WEEKEND, 60, 50)));

        hotels.add(new Hotel("Ridgewood", 5,
                new Rate(RateType.WEEKDAY, 220, 100),
                new Rate(RateType.WEEKEND, 150, 40)));

    }

    @Test
    public void testPickCheaperHotelWhenMon_Tues_Web_Regulars() throws Exception {
        HotelService hotelService = new HotelService(hotels);

        List<String> dates = new ArrayList<String>();
        dates.add("16Mar2009(mon)");
        dates.add("17Mar2009(tues)");
        dates.add("18Mar2009(wed)");

        CustomerType customerType = CustomerType.parseCustomerType("Regular");

        Hotel hotel = hotelService.find(customerType,dates);
        assertThat(hotel.getName(), is("Lakewood"));
    }

    @Test
    public void testPickCheaperHotelWhenFri_Sat_Sun_Regulars() throws Exception {
        HotelService hotelService = new HotelService(hotels);

        List<String> dates = new ArrayList<String>();
        dates.add("20Mar2009(fri)");
        dates.add("21Mar2009(sat)");
        dates.add("22Mar2009(sun)");

        CustomerType customerType = CustomerType.parseCustomerType("Regular");

        Hotel hotel = hotelService.find(customerType,dates);
        assertThat(hotel.getName(), is("Bridgewood"));
    }

    @Test
    public void testPickCheaperHotelWhenThur_Fri_Sat_Reward() throws Exception {
        HotelService hotelService = new HotelService(hotels);

        List<String> dates = new ArrayList<String>();
        dates.add("26Mar2009(thur)");
        dates.add("27Mar2009(fri)");
        dates.add("28Mar2009(sat)");

        CustomerType customerType = CustomerType.parseCustomerType("Rewards");

        Hotel hotel = hotelService.find(customerType,dates);
        assertThat(hotel.getName(), is("Ridgewood"));
    }


}
