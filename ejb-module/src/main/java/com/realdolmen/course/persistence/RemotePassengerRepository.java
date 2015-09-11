package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.Ticket;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by OCPAX79 on 11/09/2015.
 */
@Remote
public interface RemotePassengerRepository {
    List<Passenger> findAll();

    List<String> findAllLastNames();

    long totalFrequentFlyerMiles();

    List<Ticket> findTicketsByPassengerId(long id);

    void deleteAll();

    void remove(long id);
}
