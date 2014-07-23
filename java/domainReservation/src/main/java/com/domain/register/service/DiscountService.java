package com.domain.register.service;

import java.math.BigDecimal;

public class DiscountService {
    private BigDecimal discount;

    public BigDecimal getDiscount() {
        return discount;
    }

    public DiscountService(double discount) {
        this.discount = new BigDecimal(discount);
    }
}
