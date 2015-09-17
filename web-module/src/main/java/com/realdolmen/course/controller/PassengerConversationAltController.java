package com.realdolmen.course.controller;

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.PassengerType;
import com.realdolmen.course.persistence.PassengerEJB;
import com.realdolmen.course.persistence.PassengerNamedBean;

import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by OCPAX79 on 16/09/2015.
 */
@Named
@ConversationScoped
public class PassengerConversationAltController implements Serializable {
    @EJB
    PassengerEJB passengerEJB;

    @Inject
    private Conversation conversation;

    private String selectedPassengerType;
    private Passenger passenger;

    //@Produces
    public Passenger getPassenger() {
        return passenger;
    }

    //start conversation
    public String startConversation() {
        passenger = new Passenger();
        conversation.begin();
        return "passengerCreateConversation";
    }

    //for conversation
    public String createPassengerForConversation() {
        passenger.setDateOfBirth(new Date());
        passenger.setLastFlight(new Date());

        PassengerType passengerType = Enum.valueOf(PassengerType.class, selectedPassengerType);
        passenger.setPassengerType(passengerType);

        return "confirmConversation";
    }

    //end conversation
    public String confirmConversation() {
        passengerEJB.createPassenger(passenger);
        conversation.end();
        return "passengers";
    }

    public String getSelectedPassengerType() {
        return selectedPassengerType;
    }

    public void setSelectedPassengerType(String selectedPassengerType) {
        this.selectedPassengerType = selectedPassengerType;
    }

    public PassengerEJB getPassengerEJB() {
        return passengerEJB;
    }

    public void setPassengerEJB(PassengerEJB passengerEJB) {
        this.passengerEJB = passengerEJB;
    }
}
