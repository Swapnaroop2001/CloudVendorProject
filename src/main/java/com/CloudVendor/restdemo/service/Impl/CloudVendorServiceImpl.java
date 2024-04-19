package com.CloudVendor.restdemo.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CloudVendor.restdemo.exception.CloudVendorNotFoundException;
import com.CloudVendor.restdemo.model.CloudVendor;
import com.CloudVendor.restdemo.repository.CloudVendorRepository;
import com.CloudVendor.restdemo.service.CloudVendorService;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    CloudVendorRepository cloudVendorRepository;
    

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Created Successfully!";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Upated Successfully!";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        cloudVendorRepository.deleteById(cloudVendorId);
        return "Deleted Successfully";
    }

    @Override
    public List<CloudVendor> getAllCloudVedors() {
        return cloudVendorRepository.findAll();
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {

        if (cloudVendorRepository.findById(cloudVendorId).isEmpty()) {
            throw new CloudVendorNotFoundException("Requested Cloud vendor is not available");
        }
        return cloudVendorRepository.findById(cloudVendorId).get();
    }

    

}
