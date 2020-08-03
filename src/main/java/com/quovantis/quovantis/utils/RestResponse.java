package com.quovantis.quovantis.utils;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by Dhiraj on 31-07-2020.
 */
public class RestResponse<T> implements Serializable {

    private static final long serialVersionUID = -5828498329416467532L;

    private String statusCode;
    private String message;
    private T entity;
    private Map<String,Object> validationErrors;

    public RestResponse(String statusCode, String message) {
        super();
        this.statusCode = statusCode;
        this.message = message;
    }

    public RestResponse(String statusCode, T entity, String message) {
        super();
        this.statusCode = statusCode;
        this.entity = entity;
        this.message = message;
    }

    public RestResponse(T entity,String statusCode) {
        super();
        this.entity = entity;
        this.statusCode = statusCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public T getEntity() {
        return entity;
    }
    public void setEntity(T entity) {
        this.entity = entity;
    }


}

