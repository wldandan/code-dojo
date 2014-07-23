package com.domain.register.model.domain;

import com.domain.register.model.bill.BillItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;



public class DomainTest {

    @Test
    public void should_get_zone_domain_when_created() throws Exception {
        Domain zoneDomain = new Domain(DomainType.ZONE, ".com", new BigDecimal(10));
        assertThat(zoneDomain.getName(), is(".com"));
        assertThat(zoneDomain.getPrice(), is(new BigDecimal(10)));
        assertThat(zoneDomain.getDomainType(), is(DomainType.ZONE));
    }

    @Test
    public void should_get_premium_domain_when_created() throws Exception {
        Domain premiumDomain = new Domain(DomainType.PREMIUM, "dict.com", new BigDecimal(800));
        assertThat(premiumDomain.getName(), is("dict.com"));
        assertThat(premiumDomain.getPrice(), is(new BigDecimal(800)));
        assertThat(premiumDomain.getDomainType(), is(DomainType.PREMIUM));
    }

    @Test
    public void should_get_string_message() throws Exception {
        Domain domain = new Domain(DomainType.PREMIUM, "dict.com", new BigDecimal(800));
        assertThat(domain.toString(), is("dict.com,800"));
    }

}
