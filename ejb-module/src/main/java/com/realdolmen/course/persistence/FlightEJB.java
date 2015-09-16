package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Flight;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by OCPAX79 on 16/09/2015.
 */
@Stateless
@LocalBean
public class FlightEJB implements RemoteFlightEJB {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Flight getFeaturedFlight() {
        return em.find(Flight.class, 1000l);
    }
}
