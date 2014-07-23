package com.domain.register.console;

import com.domain.register.console.exception.DomainRegisterException;
import com.domain.register.service.BillService;
import com.domain.register.service.DomainService;

import java.io.*;

public class CLI {
    public static void main(String[] args) throws DomainRegisterException {
        InputStream is = null;
        OutputStream os = null;

        if (args.length > 0){
            try {
                is = new FileInputStream(new File(args[0]));
            } catch (FileNotFoundException e) {
                throw new DomainRegisterException(e.getMessage());
            }
        }

        if (args.length > 1){
            try {
                os = new FileOutputStream(new File(args[1]));
            } catch (FileNotFoundException e) {
                throw new DomainRegisterException(e.getMessage());
            }
        }

        if (null == is){
            is = System.in;
        }

        if (null == os){
            os = System.out;
        }

        DomainService domainService = new DomainService();
        BillService billService = new BillService(domainService);

        DomainRegister domainRegister = new DomainRegister(billService, is, os);
        try {
            domainRegister.initialize();
            domainRegister.run();
        } catch (Exception e) {
            throw new DomainRegisterException(e.getMessage());
        }
    }
}
