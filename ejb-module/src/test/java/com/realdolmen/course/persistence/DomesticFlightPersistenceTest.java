package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.DomesticFlight;
import com.realdolmen.course.domain.Flight;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Date;

/**
 * Created by OCPAX79 on 10/09/2015.
 */
public class DomesticFlightPersistenceTest extends DataSetPersistenceTest {
    @Rule
    public ExpectedException expector = ExpectedException.none();

    @Test
    public void testDomesticFlightCanBePersisted() {
        Flight flight = new DomesticFlight("001", new Date(), new Date(), "Jetair");
        entityManager().persist(flight);
        assertNotNull(flight.getId());
    }
}
