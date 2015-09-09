package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Passenger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by OCPAX79 on 9/09/2015.
 */
public class PassengerPersistenceTest extends DataSetPersistenceTest {
    @Rule
    public ExpectedException expector = ExpectedException.none();

    @Test
    public void passengerCanBePersisted() {
        Passenger passenger = new Passenger("003", "rafael", "nadal", 70);
        entityManager().persist(passenger);
        assertNotNull(passenger.getId());
    }

    @Test
    public void passengerCanBeRetrievedById() throws Exception {
        assertEquals("001", entityManager().find(Passenger.class, 1000l).getSsn());
    }
}
