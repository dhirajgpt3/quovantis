package com.quovantis.quovantis.model;


import java.io.Serializable;

/**
 * Created by Dhiraj on 31-07-2020.
 */

public class ApplicationBean implements Serializable {

    private Long applicationId;
   // private String offerId;
    private String candidateEmail;
    private String applicationStatus;
    private String resumeText;
    private OfferBean offerBean;

    public OfferBean getOfferBean() {
        return offerBean;
    }

    public void setOfferBean(OfferBean offerBean) {
        this.offerBean = offerBean;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

//    public String getOfferId() {
//        return offerId;
//    }
//
//    public void setOfferId(String offerId) {
//        this.offerId = offerId;
//    }

    public String getCandidateEmail() {
        return candidateEmail;
    }

    public void setCandidateEmail(String candidateEmail) {
        this.candidateEmail = candidateEmail;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
    public String getResumeText() {
        return resumeText;
    }

    public void setResumeText(String resumeText) {
        this.resumeText = resumeText;
    }

}
