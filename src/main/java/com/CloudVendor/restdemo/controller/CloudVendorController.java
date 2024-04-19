package com.CloudVendor.restdemo.controller;

import com.CloudVendor.restdemo.model.CloudVendor;
import com.CloudVendor.restdemo.responseHandler.ResponseHandler;
import com.CloudVendor.restdemo.service.CloudVendorService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

    CloudVendorService cloudVendorService;
    //Contructor
    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }


    CloudVendor cloudVendor;

    //Get Specific vendor
    @GetMapping("{vendorId}")
    public ResponseEntity<Object>  getCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        return ResponseHandler.ResponseBuilder("Requested data is fetched", HttpStatus.OK, cloudVendorService.getCloudVendor(vendorId));
        
    }

    //Get All vendors
    @GetMapping()
    public List<CloudVendor> getAllCloudVendorDetails(){
        return cloudVendorService.getAllCloudVedors();
    }

    //create
    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.createCloudVendor(cloudVendor);
        return "Cloud vendor created successfully!";
    }

    //update
    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "Cloud vendor updated successfully!";
    }

    //delete
    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud vendor Deleted successfully!";
    }
}
