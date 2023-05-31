package com.yash.restcruddemo.impl;

import com.yash.restcruddemo.model.CloudVendor;
import com.yash.restcruddemo.repository.CloudVendorRepository;
import com.yash.restcruddemo.service.CloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


class CloudVendorServiceImplTest
 {

     @Mock
     private CloudVendorRepository cloudVendorRepository;
     CloudVendorService cloudVendorService;
     AutoCloseable autoCloseable;
     CloudVendor cloudVendor;
    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        cloudVendorService =  new CloudVendorServiceImpl(cloudVendorRepository);
        cloudVendor = new CloudVendor("1","Amzaon",
                "USA","9561780738");

    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testCreateCloudVendor() {
     mock(CloudVendor.class);
     mock(CloudVendorRepository.class);
     when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
     assertThat(cloudVendorService.createCloudVendor(cloudVendor)).isEqualTo("customer added successfully");
    }

    @Test
    void testUpdateCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);
        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(cloudVendorService.updateCloudVendor(cloudVendor)).isEqualTo("success");

    }

    @Test
    void testGetCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.findById("1")).thenReturn(Optional.ofNullable(cloudVendor));
        assertThat(cloudVendorService.getCloudVendor("1").getVendorName())
                        .isEqualTo(cloudVendor.getVendorName());
    }

    @Test
    void testGetAllCloudVendors() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.findAll()).thenReturn(
                new ArrayList<CloudVendor>(Collections.singleton(cloudVendor))
        );
       assertThat(cloudVendorService.getAllCloudVendors().get(0).getVendorPhoneNumber())
               .isEqualTo(cloudVendor.getVendorPhoneNumber());
    }

    @Test
    void testFindByVendorName() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.findByVendorNameContaining("Amazon")).thenReturn(
                new ArrayList<CloudVendor>(Collections.singleton(cloudVendor))
        );
        assertThat(cloudVendorService.findByVendorName("Amazon").get(0).getVendorId())
                .isEqualTo(cloudVendor.getVendorId());

    }

     @Test
     void testDeleteCloudVendor() {
         mock(CloudVendor.class);
         mock(CloudVendorRepository.class, Mockito.CALLS_REAL_METHODS);

         doAnswer(Answers.CALLS_REAL_METHODS).when(
                 cloudVendorRepository).deleteById(any());
         assertThat(cloudVendorService.deleteCloudVendor("1")).isEqualTo("success");
     }
}