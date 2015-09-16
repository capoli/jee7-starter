package com.realdolmen.course.controller;

import com.realdolmen.course.domain.Flight;
import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.PassengerType;
import com.realdolmen.course.persistence.FlightEJB;
import com.realdolmen.course.persistence.PassengerEJB;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Date;
import java.util.List;

/**
 * Created by OCPAX79 on 15/09/2015.
 */
@Named
@RequestScoped
public class PassengerController {
    @EJB
    PassengerEJB passengerEJB;
    @EJB
    FlightEJB flightEJB;

    private Passenger passenger = new Passenger();
    private String selectedPassengerType;

    public List<Passenger> getAllPassengers() {
        return passengerEJB.findPassengers();
    }

    public String create() {
        passenger.setDateOfBirth(new Date());
        passenger.setLastFlight(new Date());

        PassengerType passengerType = Enum.valueOf(PassengerType.class, selectedPassengerType);
        passenger.setPassengerType(passengerType);
        passengerEJB.createPassenger(passenger);
        return "passengers";
    }

    public Flight getFeaturedFlight() {
        return flightEJB.getFeaturedFlight();
    }

    public List<String> getAllPassengerTypes() {
        return passengerEJB.getPassengerTypes();
    }

    public PassengerEJB getPassengerEJB() {
        return passengerEJB;
    }

    public void setPassengerEJB(PassengerEJB passengerEJB) {
        this.passengerEJB = passengerEJB;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public String getSelectedPassengerType() {
        return selectedPassengerType;
    }

    public void setSelectedPassengerType(String selectedPassengerType) {
        this.selectedPassengerType = selectedPassengerType;
    }
}
