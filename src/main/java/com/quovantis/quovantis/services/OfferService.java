package com.quovantis.quovantis.services;


import com.quovantis.quovantis.model.*;

import java.util.List;

/**
 * Created by Dhiraj on 31-07-2020.
 */

public interface OfferService {
    void save(OfferBean offerBean) throws Exception;
    OfferBean  getOffer(String offerId);
    List<OfferBean> getOffers();
  }
