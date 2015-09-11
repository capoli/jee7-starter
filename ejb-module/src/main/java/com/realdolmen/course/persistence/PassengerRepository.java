package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.Ticket;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by OCPAX79 on 9/09/2015.
 */
@Stateless
@LocalBean
public class PassengerRepository {
    @PersistenceContext
    EntityManager entityManager;

    public List<Passenger> findAll() {
        return entityManager.createQuery("select p from Passenger p", Passenger.class).getResultList();
    }

    public List<String> findAllLastNames() {
        return entityManager.createQuery("select p.lastName from Passenger p", String.class).getResultList();
    }

    public long totalFrequentFlyerMiles() {
        return entityManager.createQuery("select sum(p.frequentFlyerMiles) from Passenger p", Long.class).getSingleResult();
    }

    public List<Ticket> findTicketsByPassengerId(long id) {
        return entityManager.find(Passenger.class, id).getTickets();
    }

    public void deleteAll() {
        //entityManager.createQuery("delete from Passenger p").executeUpdate();// -> door geen cascade gaat dit niet zo
        for(Passenger p : findAll()) {
            //p.clearCreditCards();
            p.clearTickets();
            remove(p.getId());
        }
    }

    public void remove(long id) {
        entityManager.remove(entityManager.getReference(Passenger.class, id));
    }
}
