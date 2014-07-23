package com.domain.register.console;

import com.domain.register.console.exception.DomainRegisterException;
import com.domain.register.model.bill.Bill;
import com.domain.register.model.domain.Domain;
import com.domain.register.parameter.DomainRegisterRequest;
import com.domain.register.service.BillService;
import com.domain.register.service.DomainService;
import com.domain.register.service.exception.NotFoundDomainException;

import java.io.*;
import java.util.List;

import static com.domain.register.console.DomainRegisterHelper.*;

public class DomainRegister {

    private final BillService billService;
    private final DomainService domainService;
    private final InputStream inputStream;
    private final OutputStream outputStream;


    public DomainRegister(BillService billService, InputStream inputStream, OutputStream outputStream) {
        this.billService = billService;
        this.domainService = billService.getDomainService();
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    public void initialize() throws IOException {
        for(Domain domain : DomainRegisterHelper.loadApplicationData()){
            domainService.addDomain(domain);
        }
        printDomainInfo();
    }

    public void run() throws DomainRegisterException, IOException, NotFoundDomainException {

        List<DomainRegisterRequest> requests = parseRequests(inputStream);

        for (DomainRegisterRequest request: requests){
            outputStream.write((request.toString()+"\r\n").getBytes());
        }
        outputStream.write(DOMAIN_MSG_SEPARATOR.getBytes());

        Bill bill = billService.generateBill(requests);
        outputStream.write((bill.toString()).getBytes());
    }

    private void printDomainInfo() throws IOException {
        outputStream.write(ZONE_PREMIUM_DOMAINS_MSG.getBytes());

        outputStream.write(DOMAIN_MSG_SEPARATOR.getBytes());
        for(Domain domain : domainService.getZoneDomains()){
            outputStream.write((domain.toString() + "\r\n").getBytes());
        }

        outputStream.write("\r\n\n".getBytes());

        outputStream.write(PREMIUM_DOMAINS_MSG.getBytes());
        outputStream.write(DOMAIN_MSG_SEPARATOR.getBytes());
        for(Domain domain : domainService.getPremiumDomains()){
            outputStream.write((domain.toString() + "\r\n" ).getBytes());
        }

        outputStream.write("\r\n\n".getBytes());
        outputStream.write(INPUT_DOMAINS_MSG.getBytes());
        outputStream.write(DOMAIN_MSG_SEPARATOR.getBytes());
    }
}
