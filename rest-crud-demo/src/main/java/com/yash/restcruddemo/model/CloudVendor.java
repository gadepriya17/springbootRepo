package com.yash.restcruddemo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cloud_vendor_info")
@ApiModel(description = "This tables holds Cloud vendor information.")
public class CloudVendor
{
    @Id
    @ApiModelProperty(notes = "This is a cloud vendor ID, It shall be unique.")
    private String vendorId;
    private String vendorName;
    private String vendorAddress;
    private String vendorPhoneNumber;
    private String vendorEmailId;
    private  String vendorPassword;


    public CloudVendor()
    {
    }

    public CloudVendor(String vendorId, String vendorName, String vendorAddress, String vendorPhoneNumber, String vendorEmailId, String vendorPassword) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.vendorAddress = vendorAddress;
        this.vendorPhoneNumber = vendorPhoneNumber;
        this.vendorEmailId = vendorEmailId;
        this.vendorPassword = vendorPassword;
    }

    public String getVendorEmailId() {
        return vendorEmailId;
    }

    public void setVendorEmailId(String vendorEmailId) {
        this.vendorEmailId = vendorEmailId;
    }

    public String getVendorPassword() {
        return vendorPassword;
    }

    public void setVendorPassword(String vendorPassword) {
        this.vendorPassword = vendorPassword;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorAddress() {
        return vendorAddress;
    }

    public void setVendorAddress(String vendorAddress) {
        this.vendorAddress = vendorAddress;
    }

    public String getVendorPhoneNumber() {
        return vendorPhoneNumber;
    }

    public void setVendorPhoneNumber(String vendorPhoneNumber) {
        this.vendorPhoneNumber = vendorPhoneNumber;
    }



}
