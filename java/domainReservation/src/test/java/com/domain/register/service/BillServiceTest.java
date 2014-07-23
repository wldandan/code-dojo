package com.domain.register.service;

import com.domain.register.model.bill.Bill;
import com.domain.register.model.domain.Domain;
import com.domain.register.model.domain.DomainType;
import com.domain.register.parameter.DomainRegisterRequest;
import com.domain.register.service.exception.NotFoundDomainException;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class BillServiceTest {

    private BillService billService;
    private DomainService domainService;
    private DiscountService discountService;

    @Before
    public void setUp() throws Exception {
        domainService = mock(DomainService.class);
        discountService = mock(DiscountService.class);
        billService = new BillService(domainService, discountService);
    }

    @Test
    public void should_generate_bill() throws NotFoundDomainException {
        Domain domain = new Domain(DomainType.PREMIUM, "dict.com", new BigDecimal(800));

        when(domainService.retrieveDomain("apple.com.au")).thenReturn(domain);
        when(discountService.getDiscount()).thenReturn(new BigDecimal(0));
        List<DomainRegisterRequest> requests = new ArrayList<DomainRegisterRequest>();
        requests.add(new DomainRegisterRequest("apple.com.au", 5));
        Bill bill = billService.generateBill(requests);

        assertThat(bill.calculateCost(), is(new BigDecimal(4000).setScale(2)));
        verify(domainService, times(1)).retrieveDomain("apple.com.au");
    }

    @Test
    public void should_get_discount_if_more_than_1000() throws Exception {
        when(discountService.getDiscount()).thenReturn(new BigDecimal(0.1));
        Domain domain = new Domain(DomainType.PREMIUM, "dict.com", new BigDecimal(800));

        when(domainService.retrieveDomain("apple.com.au")).thenReturn(domain);

        List<DomainRegisterRequest> requests = new ArrayList<DomainRegisterRequest>();
        requests.add(new DomainRegisterRequest("apple.com.au", 5));
        Bill bill = billService.generateBill(requests);
        assertThat(bill.calculateCost(), is(new BigDecimal(3600.00).setScale(2, BigDecimal.ROUND_HALF_UP)));
    }
}
