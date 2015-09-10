package com.realdolmen.course.domain;

import javax.persistence.Entity;

/**
 * Created by OCPAX79 on 10/09/2015.
 */
@Entity
public class InternationalFlight extends Flight {
    private boolean blackList;
    private String regulations;

    public InternationalFlight(boolean blackList, String regulations) {
        this.blackList = blackList;
        this.regulations = regulations;
    }

    public InternationalFlight() {
    }

    public boolean isBlackList() {
        return blackList;
    }

    public void setBlackList(boolean blackList) {
        this.blackList = blackList;
    }

    public String getRegulations() {
        return regulations;
    }

    public void setRegulations(String regulations) {
        this.regulations = regulations;
    }
}
