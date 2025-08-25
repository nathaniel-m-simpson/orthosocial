package com.assessment.ecfr_analytics.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Correction {
    @Id
    private Long id;

    @Column(columnDefinition = "TEXT")
    @JsonProperty("corrective_action")
    private String correctiveAction;

    @Column(columnDefinition = "TEXT")
    @JsonProperty("cfr_references")
    private String cfrReferences;

    @Column
    @JsonProperty("error_corrected")
    private String errorCorrectedDate;

    @Column
    @JsonProperty("error_occurred")
    private String errorOccurredDate;

    @Column
    private String title;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCorrectiveAction() {
        return correctiveAction;
    }

    public void setCorrectiveAction(String correctiveAction) {
        this.correctiveAction = correctiveAction;
    }

    public String getErrorCorrectedDate() {
        return errorCorrectedDate;
    }

    public void setErrorCorrectedDate(String errorCorrectedDate) {
        this.errorCorrectedDate = errorCorrectedDate;
    }

    public String getErrorOccurredDate() {
        return errorOccurredDate;
    }

    public void setErrorOccurredDate(String errorOccurredDate) {
        this.errorOccurredDate = errorOccurredDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCfrReferences() {
        return cfrReferences;
    }

    public void setCfrReferences(String cfrReferences) {
        this.cfrReferences = cfrReferences;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Correction{");
        sb.append("id=").append(id);
        sb.append(", correctiveAction='").append(correctiveAction).append('\'');
        sb.append(", cfrReferences='").append(cfrReferences).append('\'');
        sb.append(", errorCorrectedDate='").append(errorCorrectedDate).append('\'');
        sb.append(", errorOccurredDate='").append(errorOccurredDate).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
