package com.yash.restcruddemo.repository;

import com.yash.restcruddemo.model.CloudVendor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
public class CloudVendorRepositoryTest
{
   @Autowired private  CloudVendorRepository cloudVendorRepository;
   CloudVendor cloudVendor;

   @BeforeEach
   void setUp(){
      cloudVendor = new CloudVendor("c1",
              "amazon","india","9561780738","ashu@yash.com","Ashu123");
       cloudVendorRepository.save(cloudVendor);
   }

   @AfterEach
   void tearDown(){
     cloudVendor = null;
     cloudVendorRepository.deleteAll();
   }
   //test case for success \

    @Test
    void testFindByVendorName_Found()
    {
        List<CloudVendor> cloudVendorsList = cloudVendorRepository.findByVendorNameContaining("amazon");
        assertThat(cloudVendorsList.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
        assertThat(cloudVendorsList.get(0).getVendorAddress())
                .isEqualTo(cloudVendor.getVendorAddress());
    }

    //test case for failure
    @Test
    void testFindByVendorName_NotFound()
    {
        List<CloudVendor> cloudVendorsList = cloudVendorRepository.findByVendorNameContaining("GCP");
        assertThat(cloudVendorsList.isEmpty()).isTrue();
    }
 }
