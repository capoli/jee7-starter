package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Flight;
import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.Ticket;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by OCPAX79 on 15/09/2015.
 */
@Stateless
public class TicketService {
    @PersistenceContext
    private EntityManager em;

    public void createTicket(Double price, Long flightId, Long passengerId) {
        Ticket ticket = new Ticket(price);
        ticket.setFlight(em.find(Flight.class,flightId));
        ticket.setPassenger(em.find(Passenger.class, passengerId));
        em.persist(ticket);
        System.out.println("Create ticket");
    }

    public void updateTicket(Long ticketId, Double price) {
        Ticket ticket = em.find(Ticket.class, ticketId);
        ticket.setPrice(price);
        //em.persist(ticket);
        System.out.println("Update ticket");
    }
}
