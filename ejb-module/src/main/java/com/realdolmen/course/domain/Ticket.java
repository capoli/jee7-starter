package com.realdolmen.course.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by OCPAX79 on 10/09/2015.
 */
@Entity
public class Ticket implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Access(value = AccessType.PROPERTY)
    @Basic(optional = false)
    private double price;
    @ManyToOne
    @JoinColumn(name = "passenger_fk")
    private Passenger passenger;
    @ManyToOne
    @JoinColumn(name = "flight_fk")
    private Flight flight;

    public Ticket() {
    }

    public Ticket(Double price) {
        setPrice(price);
    }

    public Long getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        if(price < 0) throw new IllegalArgumentException("Ticketprice can't be negative");
        this.price = price;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
