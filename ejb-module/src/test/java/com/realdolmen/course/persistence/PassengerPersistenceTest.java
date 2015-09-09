package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.PassengerType;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Date;

/**
 * Created by OCPAX79 on 9/09/2015.
 */
public class PassengerPersistenceTest extends DataSetPersistenceTest {
    @Rule
    public ExpectedException expector = ExpectedException.none();

    @Test
    public void passengerCanBePersisted() {
        Passenger passenger = new Passenger("003", "rafael", "nadal", 70, new Date(809913600), PassengerType.OCCASIONAL, new Date(1409529600));
        entityManager().persist(passenger);
        assertNotNull(passenger.getId());
    }

    @Test
    public void passengerCanBeRetrievedById() throws Exception {
        assertEquals("001", entityManager().find(Passenger.class, 1000l).getSsn());
    }

    @Test
    public void passengerHasCorrectAge() {
        assertEquals(new Integer(24), entityManager().find(Passenger.class, 1000l).getAge());
    }
}
