package com.yash.restcruddemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CloudVendorExceptionHandler
{
    @ExceptionHandler(value = {CloudVendorNotFoundException.class })
    public ResponseEntity<Object> handleCloudVendorNotFoundException
            (CloudVendorNotFoundException cloudVendorNotFoundException )
    {
      CloudVendorException cloudVendorException  = new CloudVendorException(
              cloudVendorNotFoundException.getMessage(),
              //cloudVendorNotFoundException.getCause(),
              HttpStatus.NOT_FOUND
      );
      return new ResponseEntity<>(cloudVendorException,HttpStatus.NOT_FOUND);
    }
     @ExceptionHandler(value = CloudVendorAlreadyExistsException.class)
     @ResponseStatus(HttpStatus.CONFLICT)
    public CloudVendorException  handleCloudVendorAlreadyExistsException
            (CloudVendorAlreadyExistsException ex)
    {

        return new CloudVendorException(ex.getMessage(),HttpStatus.CONFLICT);   // (ex.getMessage());
    }
}
