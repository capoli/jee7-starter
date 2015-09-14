package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Flight;
import com.realdolmen.course.domain.Passenger;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by OCPAX79 on 14/09/2015.
 */
@Stateless
public class FlightReminderEJB {
    @PersistenceContext
    private EntityManager em;
    @Resource
    TimerService timerService;

    public void createFlightReminder(Passenger passenger, Flight flight) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(flight.getDepartureTime());
        //cal.set(Calendar.HOUR, cal.get(Calendar.HOUR) - 3);
        cal.set(Calendar.SECOND, cal.get(Calendar.SECOND) + 30);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);

        ScheduleExpression flightReminder = new ScheduleExpression()
                .year(year)
                .month(month)
                .dayOfMonth(day)
                .hour(hour)
                .minute(minute)
                .second(second);
        timerService.createCalendarTimer(flightReminder, new TimerConfig(
                new FlightReminder(passenger.getId(), flight.getId()), false));
    }

    @Timeout
    public void sendFlightReminder(Timer timer) {
        FlightReminder flightReminder = (FlightReminder) timer.getInfo();
        Passenger passenger = em.find(Passenger.class, flightReminder.getPassengerId());
        Flight flight = em.find(Flight.class, flightReminder.getFlightId());
        System.out.printf("hello %s %s, flight %s leaves in 3hours\n",
                passenger.getFirstName(), passenger.getLastName(), flight.getNumber());
    }
}