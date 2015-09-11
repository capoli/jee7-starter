package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Passenger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by OCPAX79 on 11/09/2015.
 */
@Stateless
@LocalBean
public class PassengerEJB implements RemotePassengerEJB {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Passenger> findPassengers() {
        return em.createQuery("select p from Passenger p", Passenger.class).getResultList();
    }

    @Override
    public Passenger findPassengerById(Long id) {
        return em.find(Passenger.class, id);
    }

    @Override
    public Passenger createPassenger(Passenger passenger) {
        em.persist(passenger);
        return passenger;
    }

    @Override
    public void deletePassenger(Passenger passenger) {
        em.remove(updatePassenger(passenger));
    }

    @Override
    public Passenger updatePassenger(Passenger passenger) {
        return em.merge(passenger);
    }
}
