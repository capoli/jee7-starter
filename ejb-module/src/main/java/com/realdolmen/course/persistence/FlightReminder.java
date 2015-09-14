package com.realdolmen.course.persistence;

import java.io.Serializable;

public class FlightReminder implements Serializable {
    private Long passengerId;
    private Long flightId;

    public FlightReminder() {
    }

    public FlightReminder(Long passengerId, Long flightId) {
        this.passengerId = passengerId;
        this.flightId = flightId;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public Long getFlightId() {
        return flightId;
    }
}
