package com.realdolmen.course.persistence;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by OCPAX79 on 9/09/2015.
 */
public class PassengerRepositoryTest extends DataSetPersistenceTest {
    private PassengerRepository repository;

    @Before
    public void initializeRepository() {
        repository = new PassengerRepository();
        repository.entityManager = entityManager();
    }

    @Test
    public void allPassengersCanBeRetrieved() {
        assertEquals(2, repository.findAll().size());
    }
}
