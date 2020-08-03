package com.quovantis.quovantis.controller;

import com.quovantis.quovantis.model.OfferBean;
import com.quovantis.quovantis.services.OfferService;
import com.quovantis.quovantis.utils.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * Created by Dhiraj on 31-07-2020.
 */
@RestController
public class OfferController {

    @Autowired
    OfferService offerService;
    @GetMapping(value = "/quovantis")
    public ResponseEntity<RestResponse> getListOfOccupationCode(@RequestParam(required = false) String offerId) {
        try {
            OfferBean offer =null;
            List<OfferBean> offers=null;
            if(null!=offerId) {
                offer = offerService.getOffer(offerId);
                return new ResponseEntity<>(new RestResponse(HttpStatus.OK.toString(), offer,
                        "Success"), HttpStatus.OK);
            }
            else{
            offers=offerService.getOffers();
                return new ResponseEntity<>(new RestResponse(HttpStatus.OK.toString(), offers,
                        "Success"), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new RestResponse(HttpStatus.UNPROCESSABLE_ENTITY.toString(), null,
                    "Fetch  request failed."), HttpStatus.OK);
        }
    }


    /**
     * POST  quovantis/postdata : Create a new Offer.
     * @param offerBean the offer to create
     */
    @PostMapping(value = "/quovantis/postdata" ,produces ="application/json" )

    public ResponseEntity<RestResponse> createOffer(@RequestBody OfferBean offerBean) {

             try {
                offerService.save(offerBean);
            return new ResponseEntity<>(new RestResponse(HttpStatus.OK.toString(), null, "Success"), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new RestResponse(HttpStatus.UNPROCESSABLE_ENTITY.toString(), null, "fail"), HttpStatus.OK);
        }
    }




}
