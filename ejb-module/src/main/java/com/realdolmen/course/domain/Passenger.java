package com.realdolmen.course.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by OCPAX79 on 9/09/2015.
 */
@Entity
public class Passenger implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    //@Access(value = AccessType.PROPERTY)
    private Date dateOfBirth;
    @Transient
    private Integer age;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    private PassengerType passengerType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastFlight;
    @Embedded
    private Address address;
    @ElementCollection
    @CollectionTable(name = "creditcard")
    //@MapKeyColumn(name = "number")
    private List<CreditCard> creditCards = new ArrayList<>();
    @ElementCollection
    @CollectionTable(name = "preference")
    private List<String> preferences = new ArrayList<>();
    @OneToMany(mappedBy = "passenger")
    private List<Ticket> tickets = new ArrayList<>();
    private Date dateLastUpdated;

    public Passenger() {
    }

    public Passenger(String ssn, String firstName, String lastName, Integer frequentFlyerMiles, Date dateOfBirth, PassengerType passengerType, Date lastFlight) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.frequentFlyerMiles = frequentFlyerMiles;
        this.dateOfBirth = dateOfBirth;
        //this.age = calculateAge();
        this.passengerType = passengerType;
        this.lastFlight = lastFlight;
    }

    public Passenger(String ssn, String firstName, String lastName) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @PrePersist
    @PreUpdate
    private void updateDateLastUpdated() {
        dateLastUpdated = new Date();
    }

    @PostLoad
    @PostPersist
    @PostUpdate
    public void calculateAge() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateOfBirth);
        Calendar now = Calendar.getInstance();
        age = now.get(Calendar.YEAR) - cal.get(Calendar.YEAR);
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
        //calculateAge();
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
        if(age == null) calculateAge();
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void addCreditCard(CreditCard creditCard) {
        creditCards.add(creditCard);
    }

    public void clearCreditCards() {
        creditCards = null;
    }

    public List<String> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<String> preferences) {
        this.preferences = preferences;
    }

    public void addPreference(String preference) {
        preferences.add(preference);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void clearTickets() {
        for(Ticket t : tickets) {
            t.setPassenger(null);
        }
        tickets = null;
    }
}

