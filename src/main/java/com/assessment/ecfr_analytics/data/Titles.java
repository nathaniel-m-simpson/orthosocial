package com.assessment.ecfr_analytics.data;

import com.assessment.ecfr_analytics.model.Title;

import java.util.List;

/**
 * POJO for deserializing title meta data
 */
public class Titles {

    private List<Title> titles;

    public List<Title> getTitles() {
        return titles;
    }
    public void setTitles(List<Title> titles) {
        this.titles = titles;
    }
}
