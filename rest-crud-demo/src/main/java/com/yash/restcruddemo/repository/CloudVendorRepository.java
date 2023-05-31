package com.yash.restcruddemo.repository;

import com.yash.restcruddemo.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CloudVendorRepository  extends JpaRepository<CloudVendor,String>
{
  List<CloudVendor> findByVendorNameContaining(String vendorName);
}
