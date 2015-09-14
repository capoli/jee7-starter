package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.*;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by OCPAX79 on 14/09/2015.
 */
@Stateful
public class SavePassenger {
    @PersistenceContext
    private EntityManager em;

    private Passenger passenger;

    public void createPassenger(String ssn, String firstName, String lastName) {
        passenger = new Passenger(ssn, firstName, lastName);
    }

    public void addAddress(String street1, String street2, String city, String zipcode, String country) {
        passenger.setAddress(new Address(street1, street2, city, zipcode, country));
    }

    public void addCreditCard(String number, String expiryDate, Integer controlNumber, CreditCardType creditCardType) {
        passenger.addCreditCard(new CreditCard(number, expiryDate, controlNumber, creditCardType));
    }

    public void addTicket(Double price) {
        passenger.addTicket(new Ticket(price));
    }

    @Remove
    public Passenger checkOut() {
        //em.persist(passenger);
        return passenger;
    }
}
