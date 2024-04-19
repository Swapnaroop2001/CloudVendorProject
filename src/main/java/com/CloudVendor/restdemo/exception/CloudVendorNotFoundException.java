package com.CloudVendor.restdemo.exception;

public class CloudVendorNotFoundException extends RuntimeException{
    public CloudVendorNotFoundException(String messgae){
        super(messgae);
    }
    public CloudVendorNotFoundException(String messgae, Throwable cause){
        super(messgae);
    }
}
