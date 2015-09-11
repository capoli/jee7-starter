package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.DomesticFlight;
import com.realdolmen.course.domain.Flight;
import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.Ticket;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Date;

/**
 * Created by OCPAX79 on 10/09/2015.
 */
public class TicketPersistenceTest extends DataSetPersistenceTest {
    @Rule
    public ExpectedException expector = ExpectedException.none();

    @Test
    public void testTicketCanBePersisted() {
        Ticket ticket = new Ticket(40.50);
        entityManager().persist(ticket);
        assertNotNull(ticket.getId());
    }

    @Test
    public void flightCanBeAssignedToATicket() {
        Flight flight = new DomesticFlight("001", new Date(), new Date(), "Jetair");
        Ticket ticket = entityManager().find(Ticket.class, 1000l);
        ticket.setFlight(flight);
        entityManager().persist(flight);
        entityManager().persist(ticket);
        entityManager().flush();
        assertNotNull(ticket.getFlight());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ticketPriceMustNotBeNegative() {
        Ticket ticket = new Ticket(-5.0);
        entityManager().persist(ticket);
    }


    public void passengerCanBeAssignedToATicket() {
//        Ticket ticket = entityManager().find(Ticket.class, 1000l);
//        Passenger passenger = entityManager().find(Passenger.class, 2000l);
//        ticket.setPassenger(passenger);
//        //passenger.addTicket(ticket);
//        entityManager().persist(passenger);
//        entityManager().persist(ticket);
//        entityManager().flush();
//        assertEquals(1, passenger.getTickets().size());
//        assertEquals(passenger.getId(), ticket.getPassenger().getId());
        //TODO
    }
}
