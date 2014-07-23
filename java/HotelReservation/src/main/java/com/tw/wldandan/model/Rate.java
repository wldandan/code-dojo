package com.tw.wldandan.model;

import sun.print.CUPSPrinter;

public class Rate {
    private final RateType rateType;
    private final Integer regularCost;
    private final Integer rewardCost;

    public Rate(RateType rateType, Integer regularCost, Integer rewardCost) {
        this.rateType = rateType;
        this.regularCost = regularCost;
        this.rewardCost = rewardCost;
    }

    public Integer getCost(CustomerType customerType){
        return customerType.equals(CustomerType.REGULAR)? regularCost : rewardCost;
    }

    public Integer getRegularCost() {
        return regularCost;
    }

    public Integer getRewardCost() {
        return rewardCost;
    }
}