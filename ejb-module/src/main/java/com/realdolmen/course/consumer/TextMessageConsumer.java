package com.realdolmen.course.consumer;


import com.realdolmen.course.domain.Flight;
import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.Ticket;
import com.realdolmen.course.persistence.TicketService;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.TimerService;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/exported/jms/queue/MyQueue"),
})
public class TextMessageConsumer implements MessageListener {
    /*@PersistenceContext
    private EntityManager em;*/
    @EJB
    private TicketService ticketService;

    @Override
    public void onMessage(Message message) {
        try {
            /*TextMessage textMessage = (TextMessage) message;
            System.out.println("**********************");
            System.out.println(textMessage.getText());
            System.out.println("**********************");*/
            TextMessage textMessage = (TextMessage) message;
            for(String line : textMessage.getText().split("\n")) {
                String[] strings = line.split(",");
                System.out.println("**********************");
                if(strings[0].equalsIgnoreCase("null")) {
                    ticketService.createTicket(
                            Double.parseDouble(strings[1]),
                            Long.parseLong(strings[3]),
                            Long.parseLong(strings[4]));
                }
                else {
                    ticketService.updateTicket(
                            Long.parseLong(strings[0]),
                            Double.parseDouble(strings[1]));
                }
                System.out.println("**********************");
            }
        } catch (JMSException e) {
            throw new RuntimeException("Deal with this", e);
        }
    }

    /*private void createTicket(Double price, Long flightId, Long passengerId) {
        Ticket ticket = new Ticket(price);
        ticket.setFlight(em.find(Flight.class,flightId));
        ticket.setPassenger(em.find(Passenger.class, passengerId));
        em.persist(ticket);
        System.out.println("Create ticket");
    }

    private void updateTicket(Long ticketId, Double price) {
        Ticket ticket = em.find(Ticket.class, ticketId);
        ticket.setPrice(price);
        //em.persist(ticket);
        System.out.println("Update ticket");
    }*/
}
