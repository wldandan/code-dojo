package com.domain.register.service;

import com.domain.register.model.domain.Domain;
import com.domain.register.model.domain.DomainType;
import com.domain.register.service.exception.NotFoundDomainException;

import java.util.*;

public class DomainService {

    private Map<String, Domain> premiumDomains = new HashMap<String, Domain>();
    private Map<String, Domain> zoneDomains = new HashMap<String, Domain>();

    public Domain retrieveDomain(String domainName) throws NotFoundDomainException {
        Domain domain = retrievePremiumDomain(domainName);
        if (null != domain){
            return domain;
        }
        return retrieveZoneDomain(domainName);
    }

    public void addDomain(Domain domain){
        if (domain.getDomainType() == DomainType.PREMIUM){
            premiumDomains.put(domain.getName(), domain);
        }
        else{
            zoneDomains.put(domain.getName(), domain);
        }
    }

    private Domain retrievePremiumDomain(String domainName){
        return premiumDomains.get(domainName);
    }

    private Domain retrieveZoneDomain(String domainName) throws NotFoundDomainException {
        for (String domain : zoneDomains.keySet()){
            if (domainName.endsWith(domain)){
                return zoneDomains.get(domain);
            }
        }
        throw new NotFoundDomainException(
                "The Domain " + domainName + " is not matched");
    }

    public List<Domain> getPremiumDomains(){
        return Collections.unmodifiableList(
                new ArrayList<Domain>(premiumDomains.values()));
    }

    public List<Domain> getZoneDomains(){
        return Collections.unmodifiableList(
                new ArrayList<Domain>(zoneDomains.values()));

    }

}
