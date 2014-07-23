package com.tw.wldandan.model;

public enum CustomerType {
    REGULAR("Regular"), REWARDS("Rewards");

    private static CustomerType[] enumValues = values();

    private final String value;

    CustomerType(String value){
        this.value = value;
    }

    public static CustomerType parseCustomerType(String type) throws Exception {
        for (CustomerType customerType : enumValues) {
            if (type.equals(customerType.value)) {
                return customerType;
            }
        }
        return null;
    }
}
