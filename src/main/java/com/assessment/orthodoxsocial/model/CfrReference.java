package com.assessment.orthodoxsocial.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class CfrReference {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String title;

    private String chapter;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CfrReference{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", chapter='").append(chapter).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
