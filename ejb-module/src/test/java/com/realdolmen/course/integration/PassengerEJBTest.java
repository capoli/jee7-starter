package com.realdolmen.course.integration;

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.PassengerType;
import com.realdolmen.course.persistence.PassengerEJB;
import com.realdolmen.course.persistence.RemotePassengerEJB;
import org.junit.Test;

import javax.naming.NamingException;
import java.util.Date;
import java.util.List;

/**
 * Created by OCPAX79 on 11/09/2015.
 */
public class PassengerEJBTest extends RemoteIntegrationTest {
    @Test
    public void shouldCreateAPassenger() throws NamingException {
        Passenger passenger = new Passenger("005", "tom", "temmerman", 80, new Date(), PassengerType.REGULAR, new Date());
        RemotePassengerEJB passengerEJB = lookup("ear-module-1.1/ejb-module-1.1/PassengerEJB!com.realdolmen.course.persistence.RemotePassengerEJB");
        passenger = passengerEJB.createPassenger(passenger);
        assertNotNull("ID should not be NULL", passenger.getId());
        List<Passenger> passengers = passengerEJB.findPassengers();
        assertNotNull("Passengers should not be NULL", passengers);
        assertTrue(passengers.size() > 0);
    }
}
