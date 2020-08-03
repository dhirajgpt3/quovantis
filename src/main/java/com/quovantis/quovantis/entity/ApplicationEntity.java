package com.quovantis.quovantis.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Dhiraj on 31-07-2020.
 */
@Entity
@Table(name = "Application")
public class ApplicationEntity implements Serializable {
    @Column(name = "application_id")
    private @Id
    @GeneratedValue
    Long applicationId;
    @Column(name = "candidate_email")
    private String candidateEmail;
    @Column(name = "resume_text")
    private String resumeText;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "offerid")
    private OfferEntity offer;

    @Column(name = "application_status")
    private String ApplicationStatus;


    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public OfferEntity getOffer() {
        return offer;
    }

    public void setOffer(OfferEntity offer) {
        this.offer = offer;
    }

    public String getCandidateEmail() {
        return candidateEmail;
    }

    public void setCandidateEmail(String candidateEmail) {
        this.candidateEmail = candidateEmail;
    }

    public String getResumeText() {
        return resumeText;
    }

    public void setResumeText(String resumeText) {
        this.resumeText = resumeText;
    }

    public String getApplicationStatus() {
        return ApplicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        ApplicationStatus = applicationStatus;
    }
}



