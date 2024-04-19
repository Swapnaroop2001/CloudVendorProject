package com.CloudVendor.restdemo.responseHandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
    public static ResponseEntity<Object> ResponseBuilder( String message, HttpStatus httpStatus, Object resposeObject)
    {
        Map <String,Object> response=new HashMap<>();
        response.put("Message", message);
        response.put("HttpStatus", httpStatus);
        response.put("data", resposeObject );
        
        return new ResponseEntity<>(response,httpStatus);
    }
}
