package com.quovantis.quovantis.model;

import java.util.List;

/**
 * Created by Dhiraj on 03-08-2020.
 */
public class CountingOfferBean {
    List<OfferBean> offerBeans;
    private int numberOfApplications;

    public List<OfferBean> getOfferBeans() {
        return offerBeans;
    }

    public void setOfferBeans(List<OfferBean> offerBeans) {
        this.offerBeans = offerBeans;
    }

    public int getNumberOfApplications() {
        return numberOfApplications;
    }

    public void setNumberOfApplications(int numberOfApplications) {
        this.numberOfApplications = numberOfApplications;
    }



}
