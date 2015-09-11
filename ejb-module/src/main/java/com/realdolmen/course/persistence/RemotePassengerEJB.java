package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Passenger;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by OCPAX79 on 11/09/2015.
 */
@Remote
public interface RemotePassengerEJB {
    List<Passenger> findPassengers();
    Passenger findPassengerById(Long id);
    Passenger createPassenger(Passenger passenger);
    void deletePassenger(Passenger passenger);
    Passenger updatePassenger(Passenger passenger);
}
