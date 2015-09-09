package com.realdolmen.course.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PassengerId implements Serializable {
    private String ssn;
    private String lastName;

    public PassengerId() {
    }

    public PassengerId(String ssn, String lastName) {
        this.ssn = ssn;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof PassengerId) {
            PassengerId that = (PassengerId) o;
            return lastName.equals(that.lastName) && ssn.equals(that.ssn);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return  31 * ssn.hashCode() + lastName.hashCode();
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
