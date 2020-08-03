package com.quovantis.quovantis.controller;

import com.quovantis.quovantis.model.ApplicationBean;
import com.quovantis.quovantis.model.OfferBean;
import com.quovantis.quovantis.services.ApplicationService;
import com.quovantis.quovantis.utils.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Dhiraj on 31-07-2020.
 */
@RestController
@RequestMapping(value="/quovantis")
public class ApplicationController {
    @Autowired
    ApplicationService applicationService;

    @PostMapping(value = "/save-application")
    ResponseEntity<RestResponse> createApplication(@RequestBody ApplicationBean applicationBean) {
        try {
            applicationService.save(applicationBean);
            return new ResponseEntity<>(new RestResponse(HttpStatus.OK.toString(), null, "Success"), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new RestResponse(HttpStatus.UNPROCESSABLE_ENTITY.toString(), null, "fail"), HttpStatus.OK);
        }
    }
}