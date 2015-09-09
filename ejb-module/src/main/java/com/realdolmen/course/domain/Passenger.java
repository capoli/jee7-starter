package com.realdolmen.course.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by OCPAX79 on 9/09/2015.
 */
@Entity
public class Passenger implements Serializable {
    @Id @GeneratedValue
    private Long id;
    @Basic(optional = false)
    @Column(updatable = false)
    private String ssn;
    @Column(length = 50)
    private String firstName;
    @Column(length = 50)
    private String lastName;
    private Integer frequentFlyerMiles;
    @Basic(optional = false)
    @Column(updatable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Transient
    private Integer age;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    private PassengerType passengerType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastFlight;

    public Passenger() {
    }

    public Passenger(String ssn, String firstName, String lastName, Integer frequentFlyerMiles, Date dateOfBirth, PassengerType passengerType, Date lastFlight) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.frequentFlyerMiles = frequentFlyerMiles;
        this.dateOfBirth = dateOfBirth;
        this.age = calculateAge();
        this.passengerType = passengerType;
        this.lastFlight = lastFlight;
    }

    public int calculateAge() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateOfBirth);
        return cal.get(Calendar.YEAR) - 1900;
    }

    public Long getId() {
        return id;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public void setFrequentFlyerMiles(Integer frequentFlyerMiles) {
        this.frequentFlyerMiles = frequentFlyerMiles;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        this.age = calculateAge();
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(PassengerType passengerType) {
        this.passengerType = passengerType;
    }

    public Date getLastFlight() {
        return lastFlight;
    }

    public void setLastFlight(Date lastFlight) {
        this.lastFlight = lastFlight;
    }

    public Integer getAge() {
        return age;
    }
}

