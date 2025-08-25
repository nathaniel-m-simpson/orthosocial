package com.assessment.ecfr_analytics.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Title {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    private String number;

    @Column
    private String name;

    @Column
    @JsonProperty("up_to_date_as_of")
    private String upToDateAsOf;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpToDateAsOf() {
        return upToDateAsOf;
    }

    public void setUpToDateAsOf(String upToDateAsOf) {
        this.upToDateAsOf = upToDateAsOf;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Title{");
        sb.append("number=").append(number);
        sb.append(", name='").append(name).append('\'');
        sb.append(", upToDateAsOf='").append(upToDateAsOf).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
