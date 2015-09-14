package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.DomesticFlight;
import com.realdolmen.course.domain.Flight;
import com.realdolmen.course.domain.Passenger;
import org.junit.Test;

import java.util.Date;

/**
 * Created by OCPAX79 on 14/09/2015.
 */
public class FlightReminderEJBTest extends DataSetPersistenceTest {
    @Test
    public void flightReminderEJBCanBePersisted() {
        DomesticFlight flight = new DomesticFlight("500-400", new Date(), new Date(), "Rianair");
        Passenger passenger = entityManager().find(Passenger.class, 1000l);
        entityManager().persist(flight);
        entityManager().flush();
        FlightReminderEJB flightReminderEJB = new FlightReminderEJB();
        flightReminderEJB.createFlightReminder(passenger, flight);
    }
}
