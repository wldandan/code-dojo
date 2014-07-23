package com.domain.register.parameter;

public class DomainRegisterRequest {
    private final String domainName;
    private final Integer numOfYears;

    public DomainRegisterRequest(String domainName, Integer numOfYears) {
        this.domainName = domainName;
        this.numOfYears = numOfYears;
    }

    public String getDomainName() {
        return domainName;
    }

    public Integer getNumOfYears() {
        return numOfYears;
    }

    public String toString(){
        return this.getDomainName() + "," + this.getNumOfYears();
    }
}
