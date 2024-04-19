package com.CloudVendor.restdemo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CloudVendor.restdemo.model.CloudVendor;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {
    public List<CloudVendor> findByVendorName(String vendorName);
}