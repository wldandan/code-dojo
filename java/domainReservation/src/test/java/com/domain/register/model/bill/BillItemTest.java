package com.domain.register.model.bill;

import com.domain.register.model.domain.Domain;
import com.domain.register.model.domain.DomainType;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BillItemTest {

    @Test
    public void should_cost_10_when_domain_10_with_1_year() throws Exception {
        Domain domain = new Domain(DomainType.ZONE, ".com", new BigDecimal(10));
        BillItem billItem = new BillItem(domain, "a-domain.com", 1);
        assertThat(billItem.calculateCost(), is(new BigDecimal(10)));
    }

    @Test
    public void should_cost_4000_when_domain_800_with_5_year() throws Exception {
        Domain domain = new Domain(DomainType.PREMIUM, "dict.com", new BigDecimal(800));
        BillItem billItem = new BillItem(domain, "dict.com", 5);
        assertThat(billItem.calculateCost(), is(new BigDecimal(4000)));
    }

    @Test
    public void should_get_string_message() throws Exception {
        Domain domain = new Domain(DomainType.PREMIUM, "dict.com", new BigDecimal(800));
        BillItem billItem = new BillItem(domain, "dict.com", 5);
        assertThat(billItem.toString(), is("dict.com registered for 5 at $800 per year = $4000\r\n"));
    }
}
