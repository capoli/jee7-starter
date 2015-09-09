package com.realdolmen.course.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by OCPAX79 on 9/09/2015.
 */
@Entity
@Table(name = "passenger")
@SecondaryTable(name = "passengerinfo")
public class Passenger implements Serializable {
    @EmbeddedId
    private PassengerId id;
    private String firstName;
    @Column(table = "passengerinfo")
    private Integer frequentFlyerMiles;
    @Column(table = "passengerinfo")
    @Basic(fetch = FetchType.LAZY)
    private byte[] picture;

    public Passenger() {
    }

    public Passenger(String ssn, String firstName, String lastName, Integer frequentFlyerMiles, byte[] picture) {
        this(ssn, firstName, lastName, frequentFlyerMiles);
        this.picture = picture;
    }

    public Passenger(String ssn, String firstName, String lastName, Integer frequentFlyerMiles) {
        this.id = new PassengerId(ssn, lastName);
        this.firstName = firstName;
        this.frequentFlyerMiles = frequentFlyerMiles;
    }

    public PassengerId getId() {
        return id;
    }

    public void setId(PassengerId id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public void setFrequentFlyerMiles(Integer frequentFlyerMiles) {
        this.frequentFlyerMiles = frequentFlyerMiles;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}

