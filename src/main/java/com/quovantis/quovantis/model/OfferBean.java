package com.quovantis.quovantis.model;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by Dhiraj on 31-07-2020.
 */
public class OfferBean  implements Serializable {

    private Long offerId;
    private String jobTitle;
    private Date startDate;
    private int numberOfApplications;

    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTital(String jobTital) {
        this.jobTitle = jobTitle;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getNumberOfApplications() {
        return numberOfApplications;
    }

    public void setNumberOfApplications(int numberOfApplications) {
        this.numberOfApplications = numberOfApplications;
    }

    @Override
    public String toString() {
        return "OfferBean{" +
                "offerId=" + offerId +
                ", jobTital='" + jobTitle + '\'' +
                ", startDate=" + startDate +
                ", numberOfApplications=" + numberOfApplications +
                '}';
    }

}
