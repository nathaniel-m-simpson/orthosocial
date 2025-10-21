package com.assessment.orthodoxsocial.data;

import com.assessment.orthodoxsocial.model.Title;

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
