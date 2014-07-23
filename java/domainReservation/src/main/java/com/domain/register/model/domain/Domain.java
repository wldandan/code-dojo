package com.domain.register.model.domain;

import java.math.BigDecimal;

public class Domain {

    private final String name;
    private final BigDecimal price;
    private final DomainType domainType;

    public Domain(DomainType domainType, String name, BigDecimal price) {
        this.domainType = domainType;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public DomainType getDomainType() {
        return domainType;
    }

    public String toString(){
        return String.format("%s,%s",this.name, this.price);
    }
}
