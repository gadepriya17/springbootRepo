package com.yash.restcruddemo.controller;

import com.yash.restcruddemo.model.CloudVendor;
import com.yash.restcruddemo.response.ResponseHandler;
import com.yash.restcruddemo.service.CloudVendorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudevendor")
public class CloudVendorController
{
   CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService)
    {
        this.cloudVendorService = cloudVendorService;
    }
    //read specific cloud vendor details
    @GetMapping("{vendorId}")
    @ApiOperation(value = "Cloud Vendor Id",notes = "Provides cloud vendor details",
    response = ResponseEntity.class)
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId)
    {
       return ResponseHandler.resposeBuilder("Requested vendor details are here-",
         HttpStatus.OK, cloudVendorService.getCloudVendor(vendorId));
    }

    @GetMapping("/abc/{vendorName}")
    public ResponseEntity<Object> getCloudVendorDetailsByName(@PathVariable("vendorName") String vendorName)
    {
        return ResponseHandler.resposeBuilder("Requested vendor details are here-",
                HttpStatus.OK, cloudVendorService.findByVendorName(vendorName));
    }


    //read all cloud vendor details
    @GetMapping()
    public List<CloudVendor> getAllCloudVendorDetails()
    {
        return cloudVendorService.getAllCloudVendors();
    }

    @PostMapping()
    public  String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
    {
        cloudVendorService.createCloudVendor(cloudVendor);
        return "cloud vendor created successfully!!!";
    }

    @PutMapping()
    public  String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
    {
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "cloud vendor updated successfully!!!";
    }

    @DeleteMapping("{vendorId}")
    public  String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId)
    {
        cloudVendorService.deleteCloudVendor(vendorId);
        return "cloud vendor deleted successfully!!!";
    }
}
