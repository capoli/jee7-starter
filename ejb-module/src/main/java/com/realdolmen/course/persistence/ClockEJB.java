package com.realdolmen.course.persistence;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import java.util.Date;
import java.util.Timer;

/**
 * Created by OCPAX79 on 14/09/2015.
 */
@Singleton
public class ClockEJB {
    private int counter;
    @Schedule(second = "0/10", minute = "*", hour = "*", persistent = false)
    public void printTime(Timer timer) {
        System.out.println((new Date()).toString());
        if(counter++ > 10) {
            timer.cancel();
        }
    }
}
