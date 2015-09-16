package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Passenger;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by OCPAX79 on 16/09/2015.
 */
@Model
public class PassengerProducer implements Serializable {
    @Produces
    @Named
    @ConversationScoped
    @PassengerNamedBean
    public Passenger getPassengerImpl() {
        return new Passenger();
    }
}
