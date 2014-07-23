package com.domain.register.service;

import com.domain.register.parameter.DomainRegisterRequest;
import com.domain.register.model.bill.Bill;
import com.domain.register.model.bill.BillItem;
import com.domain.register.model.domain.Domain;
import com.domain.register.service.exception.NotFoundDomainException;

import java.util.List;

public class BillService {

    private final DomainService domainService;
    private final DiscountService discountService;

    public BillService(DomainService domainService) {
        this.domainService = domainService;
        this.discountService = new DiscountService(0.1);
    }

    public BillService(DomainService domainService, DiscountService discountService) {
        this.domainService = domainService;
        this.discountService = discountService;
    }

    public Bill generateBill(List<DomainRegisterRequest> registrationRequests) throws NotFoundDomainException {

        Bill bill = new Bill(discountService.getDiscount());
        for(DomainRegisterRequest request: registrationRequests){

            Domain domain = domainService.retrieveDomain(request.getDomainName());
            BillItem item = new BillItem(
                    domain,
                    request.getDomainName(),
                    request.getNumOfYears());

            bill.addItem(item);
        }

        return bill;
    }

    public DomainService getDomainService() {
        return domainService;
    }
}
