package com.assessment.orthodoxsocial.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Agency {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String slug;


    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JsonProperty("cfr_references")
    private List<CfrReference> cfrReferences;

    public Long getId() {
        return id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CfrReference> getCfrReferences() {
        return cfrReferences;
    }

    public void setCfrReferences(List<CfrReference> cfrReferences) {
        this.cfrReferences = cfrReferences;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Agency{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", slug='").append(slug).append('\'');
        sb.append(", cfrReferences=").append(cfrReferences);
        sb.append('}');
        return sb.toString();
    }
}
