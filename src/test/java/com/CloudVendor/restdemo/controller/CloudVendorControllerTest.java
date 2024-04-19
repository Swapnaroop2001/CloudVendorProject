package com.CloudVendor.restdemo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.CloudVendor.restdemo.model.CloudVendor;
import com.CloudVendor.restdemo.service.CloudVendorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

@WebMvcTest(CloudVendorController.class)
public class CloudVendorControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean // Mock the CloudVendorService
    private CloudVendorService cloudVendorService;

    private CloudVendor cloudVendor1;
    private CloudVendor cloudVendor2;
    private List<CloudVendor> cloudVendorList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        cloudVendor1 = new CloudVendor("1", "Amazon", "USA", "xxxx");
        cloudVendor2 = new CloudVendor("2", "Zomato", "IND", "xxxx");
        cloudVendorList.add(cloudVendor1);
        cloudVendorList.add(cloudVendor2);
    }

    @AfterEach
    void tearDown() {
        // Clean up any resources if needed
    }

    @Test
    void testGetCloudVendorDetails() throws Exception {
        when(cloudVendorService.getCloudVendor("1")).thenReturn(cloudVendor1);
        this.mockMvc.perform(get("/cloudvendor/" + "1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testGetAllCloudVendorDetails() throws Exception {
        when(cloudVendorService.getAllCloudVedors()).thenReturn(cloudVendorList);
        this.mockMvc.perform(get("/cloudvendor/" + "1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testUpdateCloudVendorDetails()  throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(cloudVendor1);

        when(cloudVendorService.updateCloudVendor(cloudVendor2))
                .thenReturn("Cloud Vendor Updated Successfully");
        this.mockMvc.perform(put("/cloudvendor").contentType(MediaType.APPLICATION_JSON).content(requestJson)).andDo(print()).andExpect(status().isOk());
    }
}
