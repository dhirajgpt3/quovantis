package com.quovantis.quovantis.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Dhiraj on 31-07-2020.
 */
@Entity
@Table(name = "Offer")
public class OfferEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "offerid")
    private @Id @GeneratedValue Long offerId;
    @Column(name = "jobtitle")
    private String jobTital;
    @Column(name = "startdate")
    private Date startDate;
    @OneToMany(mappedBy="offer", cascade=CascadeType.ALL)
    private List<ApplicationEntity> applications ;

    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    public String getJobTital() {
        return jobTital;
    }

    public void setJobTital(String jobTital) {
        this.jobTital = jobTital;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "offerEntity")


    public List<ApplicationEntity> getApplications() {
        return applications;
    }

    public void setApplications(List<ApplicationEntity> applications) {
        this.applications = applications;
    }
}