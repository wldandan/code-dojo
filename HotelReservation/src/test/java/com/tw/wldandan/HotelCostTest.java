package com.tw.wldandan;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HotelCostTest {
    @Test
    public void testOrderHotelCost() throws Exception {
        List<HotelCost> hotelCosts = new ArrayList<HotelCost>();

        hotelCosts.add(new HotelCost(12));
        hotelCosts.add(new HotelCost(1));
        hotelCosts.add(new HotelCost(50));

        Collections.sort(hotelCosts, new Comparator<HotelCost>() {
            @Override
            public int compare(HotelCost hotelCost, HotelCost hotelCost2) {
                return -(hotelCost.getCost() - hotelCost2.getCost());
            }
        });


        System.out.print(hotelCosts.get(0).getCost());
    }
}
