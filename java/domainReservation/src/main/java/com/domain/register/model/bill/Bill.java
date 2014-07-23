package com.domain.register.model.bill;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Bill {
    private final BigDecimal discount;
    private List<BillItem> items = new ArrayList<BillItem>();

    public Bill(BigDecimal discount) {
        this.discount = discount;
    }

    public Bill() {
        this.discount = new BigDecimal(0);
    }

    public void addItem(BillItem item){
        this.items.add(item);
    }

    public BigDecimal calculateCost(){
        BigDecimal cost = new BigDecimal(0);
        for(BillItem item : items){
            cost = cost.add(item.calculateCost());
        }
        return cost.multiply(new BigDecimal(1).subtract(discount)).setScale(2, RoundingMode.HALF_UP);
    }

    public String toString(){
        StringBuffer buf = new StringBuffer();
        buf.append("Total cost of your request = $" + calculateCost() + "\r\n");
        for(BillItem item: items){
            buf.append("\t" + item.toString());
        }
        buf.append("\tdiscount = " + this.discount);
        return buf.toString();
    }
}
