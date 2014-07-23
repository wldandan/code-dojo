package com.domain.register.model.bill;

import com.domain.register.model.domain.Domain;
import com.domain.register.model.domain.DomainType;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BillTest {

    @Test
    public void should_calculate_multiple_items() throws Exception {
        Bill bill = new Bill();

        Domain premiumDomain = new Domain(DomainType.PREMIUM, "dict.com", new BigDecimal(800));
        BillItem premiumBillItem = new BillItem(premiumDomain, "dict.com", 5);

        Domain zoneDomain = new Domain(DomainType.ZONE, ".com", new BigDecimal(10));
        BillItem zoneBillItem = new BillItem(zoneDomain, "a-domain.com", 1);


        bill.addItem(premiumBillItem);
        bill.addItem(zoneBillItem);

        assertThat(bill.calculateCost(), is(new BigDecimal(4010).setScale(2, BigDecimal.ROUND_UP)));
    }

    @Test
    public void should_get_string_message_with_item() throws Exception {
        Bill bill = new Bill();
        Domain domain = new Domain(DomainType.PREMIUM, "dict.com", new BigDecimal(800));
        BillItem billItem = new BillItem(domain, "dict.com", 5);
        bill.addItem(billItem);

        assertThat(bill.toString(), is("Total cost of your request = $4000.00\r\n\tdict.com registered for 5 at $800 per year = $4000\r\n\tdiscount = 0"));
    }
}
