package com.assessment.ecfr_analytics.data;

import com.assessment.ecfr_analytics.model.Agency;

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
