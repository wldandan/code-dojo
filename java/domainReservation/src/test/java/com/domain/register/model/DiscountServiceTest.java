package com.domain.register.model;

import com.domain.register.service.DiscountService;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class DiscountServiceTest {
    private DiscountService discountService;

    @Test
    public void should_create_based_on_discount() throws Exception {
        discountService = new DiscountService(0.1);
        assertThat(discountService.getDiscount(), is(new BigDecimal(0.1)));
    }
}
