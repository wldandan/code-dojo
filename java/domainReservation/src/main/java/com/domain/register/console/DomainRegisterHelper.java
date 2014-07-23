package com.domain.register.console;

import com.domain.register.console.exception.DomainRegisterException;
import com.domain.register.model.domain.Domain;
import com.domain.register.model.domain.DomainType;
import com.domain.register.parameter.DomainRegisterRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.domain.register.console.exception.DomainRegisterException.ERROR_PARSE_INPUT;

public class DomainRegisterHelper {

    public static final String ZONE_PREMIUM_DOMAINS_MSG = "Domain registrar’s price list (per year) of domain registrations per in a zone \r\n";
    public static final String PREMIUM_DOMAINS_MSG = "Domain registrar’s price list (per year) of premium domain registrations \r\n";
    public static final String INPUT_DOMAINS_MSG = "Please type the domains you want to buy:\r\n";
    public static final String DOMAIN_MSG_SEPARATOR = "========================= \r\n";


    public static List<Domain> loadApplicationData(){
        List<Domain> domains = new ArrayList<Domain>();
        domains.add(new Domain(DomainType.PREMIUM, "apple.com.au", new BigDecimal(1000)));

        domains.add(new Domain(DomainType.PREMIUM, "dict.com", new BigDecimal(800)));
        domains.add(new Domain(DomainType.PREMIUM, "education.net", new BigDecimal(300)));

        domains.add(new Domain(DomainType.ZONE, ".com", new BigDecimal(10)));
        domains.add(new Domain(DomainType.ZONE, ".net", new BigDecimal(9)));
        domains.add(new Domain(DomainType.ZONE, ".com.au", new BigDecimal(20)));

        return domains;
    }

    public static List<DomainRegisterRequest> parseRequests(InputStream inputStream) throws DomainRegisterException {
        List<DomainRegisterRequest> inputList = new ArrayList<DomainRegisterRequest>();
        BufferedReader in = new BufferedReader( new InputStreamReader(inputStream) );

        String line = "";
        try {
            while (null != ( line = in.readLine()) && (line.trim().length() > 0 ))
            {
                inputList.add(parse(line.trim()));
            }
        } catch (IOException e) {
            throw new DomainRegisterException(e.getMessage());
        }

        return inputList;
    }

    private static DomainRegisterRequest parse(String inputLine) throws DomainRegisterException
    {
        DomainRegisterRequest request;

        String inputData[] = inputLine.trim().split(",");

        if (inputData.length < 2)
        {
            throw new DomainRegisterException(ERROR_PARSE_INPUT);
        }

        try
        {
            String purchaseDomain = inputData[0];
            Integer numOfYears = Integer.parseInt(inputData[1]);
            request = new DomainRegisterRequest(purchaseDomain, numOfYears);
        } catch (Exception e)
        {
            throw new DomainRegisterException(ERROR_PARSE_INPUT);
        }
        return request;
    }

}
