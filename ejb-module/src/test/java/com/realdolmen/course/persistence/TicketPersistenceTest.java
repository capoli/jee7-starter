package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Ticket;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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

    public void flightCanBeAssignedToATicket() {
        //TODO
    }

    @Test(expected = IllegalArgumentException.class)
    public void passengerCanBeAssignedToATicket() {
        Ticket ticket = new Ticket(-5.0);
        entityManager().persist(ticket);
    }

    public void ticketPriceMustNotBeNegative() {
        //TODO
    }
}
