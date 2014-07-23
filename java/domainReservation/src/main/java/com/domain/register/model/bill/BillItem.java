package com.domain.register.model.bill;

import com.domain.register.model.domain.Domain;

import java.math.BigDecimal;

public class BillItem {
    private final Integer numOfYears;
    private final Domain domain;
    private final String purchaseDomainName;


    public BillItem(Domain domain, String purchaseDomainName, Integer numOfYears){
        this.domain = domain;
        this.numOfYears = numOfYears;
        this.purchaseDomainName = purchaseDomainName;
    }

    public BigDecimal calculateCost() {
        return domain.getPrice().multiply(new BigDecimal(numOfYears));
    }

    public String toString(){
        return String.format("%s registered for %s at $%s per year = $%s\r\n",
                purchaseDomainName, numOfYears, domain.getPrice(), calculateCost());
    }
}