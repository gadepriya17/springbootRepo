package com.yash.restcruddemo.impl;

import com.yash.restcruddemo.exception.CloudVendorAlreadyExistsException;
import com.yash.restcruddemo.exception.CloudVendorNotFoundException;
import com.yash.restcruddemo.model.CloudVendor;
import com.yash.restcruddemo.repository.CloudVendorRepository;
import com.yash.restcruddemo.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class CloudVendorServiceImpl implements CloudVendorService
{
    CloudVendorRepository cloudVendorRepository;
    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }


    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        //,String vendorName
        CloudVendor existingVendor = cloudVendorRepository.findById(cloudVendor.getVendorId())
                .orElse(null);
        if(existingVendor == null )
        {
            cloudVendorRepository.save(cloudVendor);
            return "customer added successfully";
        }
        else
            throw new CloudVendorAlreadyExistsException("Customer already exist!");
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        CloudVendor exsitingVendor = cloudVendorRepository.findById(cloudVendor.getVendorId())
                        .orElse(null);

        if(exsitingVendor == null)
        {
            cloudVendorRepository.save(cloudVendor);
            return "success";
        }
        else
        {
            throw new CloudVendorNotFoundException("no such vendor exitsts!!");
        }
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        cloudVendorRepository.deleteById(cloudVendorId);
        return "success";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        if(cloudVendorRepository.findById(cloudVendorId).isPresent())
        {
            return cloudVendorRepository.findById(cloudVendorId).get();
        }
        else
        {
            throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
        }

    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorRepository.findAll();
    }

    @Override
    public List<CloudVendor> findByVendorName(String vendorName)
    {
        return cloudVendorRepository.findByVendorNameContaining(vendorName);
    }
}
