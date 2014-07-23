package com.tw.wldandan.service;

import com.tw.wldandan.model.CustomerType;
import com.tw.wldandan.model.Hotel;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HotelService {

    private final List<Hotel> hotels;

    public HotelService(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public Hotel find(final CustomerType customerType, final List<String> days) throws Exception {

        Collections.sort(hotels, new Comparator<Hotel>() {

            @Override
            public int compare(Hotel hotel, Hotel hotel2) {
                Integer costCompareResult = null;
                try {
                    costCompareResult = hotel.getCostByDays(customerType, days)
                            - hotel2.getCostByDays(customerType, days);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (costCompareResult == 0){
                    return hotel2.getRating() - hotel.getRating();
                }
                return costCompareResult;
            }
        });

        return hotels.get(0);
    }

}
