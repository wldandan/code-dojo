package com.domain.register.service;

import com.domain.register.model.domain.Domain;
import com.domain.register.model.domain.DomainType;
import com.domain.register.service.exception.NotFoundDomainException;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DomainServiceTest {

    private DomainService domainService = new DomainService();

    @Before
    public void setup() {
        domainService.addDomain(new Domain(DomainType.PREMIUM, "apple.com.au", new BigDecimal(1000)));
        domainService.addDomain(new Domain(DomainType.PREMIUM, "dict.com", new BigDecimal(800)));
        domainService.addDomain(new Domain(DomainType.PREMIUM, "education.net", new BigDecimal(300)));

        domainService.addDomain(new Domain(DomainType.ZONE, ".com", new BigDecimal(10)));
        domainService.addDomain(new Domain(DomainType.ZONE, ".net", new BigDecimal(9)));
        domainService.addDomain(new Domain(DomainType.ZONE, ".com.au", new BigDecimal(20)));
    }


    @Test
    public void should_get_zone_domain_when_not_in_premium_domain_list() throws Exception {
        Domain comZoneDomain = domainService.retrieveDomain("a-domain.com");
        assertThat(comZoneDomain.getDomainType(), is(DomainType.ZONE));
        assertThat(comZoneDomain.getName(), is(".com"));

        Domain netZoneDomain = domainService.retrieveDomain("another-domain.net");
        assertThat(netZoneDomain.getDomainType(), is(DomainType.ZONE));
        assertThat(netZoneDomain.getName(), is(".net"));

        Domain comDotAuZoneDomain = domainService.retrieveDomain("c-domain.com.au");
        assertThat(comDotAuZoneDomain.getDomainType(), is(DomainType.ZONE));
        assertThat(comDotAuZoneDomain.getName(), is(".com.au"));
    }

    @Test
    public void should_get_premium_domain_when_in_premium_domain_list() throws Exception {
        Domain applePremiumDomain = domainService.retrieveDomain("apple.com.au");
        assertThat(applePremiumDomain.getDomainType(), is(DomainType.PREMIUM));
        assertThat(applePremiumDomain.getName(), is("apple.com.au"));

        Domain dictPremiumDomain = domainService.retrieveDomain("dict.com");
        assertThat(dictPremiumDomain.getDomainType(), is(DomainType.PREMIUM));
        assertThat(dictPremiumDomain.getName(), is("dict.com"));

        Domain educationPremiumDomain = domainService.retrieveDomain("education.net");
        assertThat(educationPremiumDomain.getDomainType(), is(DomainType.PREMIUM));
        assertThat(educationPremiumDomain.getName(), is("education.net"));
    }


    @Test(expected=NotFoundDomainException.class)
    public void should_get_null_when_not_in_premium_and_zone_domain_list() throws Exception {
        domainService.retrieveDomain("abc.com.cn");
    }

    @Test(expected=UnsupportedOperationException.class)
    public void should_fail_when_modify_premium_domain_list() throws Exception {
        List<Domain> domainList = domainService.getPremiumDomains();
        Domain zoneDomain = new Domain(DomainType.PREMIUM, "google.com", new BigDecimal(10));
        domainList.add(zoneDomain);
    }

    @Test(expected=UnsupportedOperationException.class)
    public void should_fail_when_modify_zone_domain_list() throws Exception {
        List<Domain> domainList = domainService.getZoneDomains();
        Domain zoneDomain = new Domain(DomainType.ZONE, ".com", new BigDecimal(10));
        domainList.add(zoneDomain);
    }

}
