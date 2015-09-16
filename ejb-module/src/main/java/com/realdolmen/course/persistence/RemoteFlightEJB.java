package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Flight;
import com.realdolmen.course.domain.Passenger;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by OCPAX79 on 11/09/2015.
 */
@Remote
public interface RemoteFlightEJB {
    Flight getFeaturedFlight();
}
