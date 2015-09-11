package com.realdolmen.course.domain;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by OCPAX79 on 10/09/2015.
 */
@Entity
public class DomesticFlight extends Flight {
    private String airlineCompany;
    @ElementCollection
    @CollectionTable(name = "ref")
    private List<String> references = new ArrayList<>();

    public DomesticFlight(String number, Date departureTime, Date arrivalTime, String airlineCompany) {
        super(number, departureTime, arrivalTime);
        this.airlineCompany = airlineCompany;
    }

    public DomesticFlight() {
    }

    public String getAirlineCompany() {
        return airlineCompany;
    }

    public void setAirlineCompany(String airlineCompany) {
        this.airlineCompany = airlineCompany;
    }

    public List<String> getReferences() {
        return references;
    }

    public void addReference(String reference) {
        references.add(reference);
    }
}
