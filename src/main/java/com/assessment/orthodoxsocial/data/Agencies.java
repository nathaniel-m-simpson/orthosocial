package com.assessment.orthodoxsocial.data;

import com.assessment.orthodoxsocial.model.Agency;

import java.util.List;

/**
 * POJO for deserializing agency meta data
 */
public class Agencies {

    private List<Agency> agencies;

    public List<Agency> getAgencies() {
        return agencies;
    }

    public void setAgencies(List<Agency> agencies) {
        this.agencies = agencies;
    }
}
