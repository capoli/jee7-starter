package com.realdolmen.course.domain;

import javax.persistence.MappedSuperclass;

/**
 * Created by OCPAX79 on 10/09/2015.
 */
@MappedSuperclass
public class AbstractEntity {
    private String abstractField;

    public AbstractEntity() {
    }

    public AbstractEntity(String abstractField) {
        this.abstractField = abstractField;
    }

    public String getAbstractField() {
        return abstractField;
    }

    public void setAbstractField(String abstractField) {
        this.abstractField = abstractField;
    }
}
