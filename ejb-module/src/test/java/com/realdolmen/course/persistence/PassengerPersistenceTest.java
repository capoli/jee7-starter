package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.PassengerId;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

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

    @Test(expected = PersistenceException.class)
    public void passengerCanNotBePersisted() {
        Passenger passenger = new Passenger("005", "fred", null, 70);
        entityManager().persist(passenger);
        entityManager().flush();
    }

    @Test
     public void passengerCanBeRetrievedById() throws Exception {
        assertEquals("gert", entityManager().find(Passenger.class, new PassengerId("001", "verhulst")).getFirstName());
    }

    @Test
    public void passengerinfoCanBeRetrievedById() throws Exception {
        assertEquals(new Integer(60), entityManager().find(Passenger.class, new PassengerId("001", "verhulst")).getFrequentFlyerMiles());
    }
}
