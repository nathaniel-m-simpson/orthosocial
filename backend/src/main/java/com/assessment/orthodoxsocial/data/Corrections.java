package com.assessment.orthodoxsocial.data;

import com.assessment.orthodoxsocial.model.Correction;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * POJO for deserializing corrections data
 */
public class Corrections {

    @JsonProperty("ecfr_corrections")
    private List<Correction> corrections;

    public List<Correction> getCorrections() {
        return corrections;
    }

    public void setCorrections(List<Correction> corrections) {
        this.corrections = corrections;
    }
}
