package com.yash.restcruddemo.exception;

import org.springframework.http.HttpStatus;

public class CloudVendorException
{
    private final   String message;
   // private  final Throwable throwable;
    private final HttpStatus httpstatus;

    private int statusCode;



    public CloudVendorException(String message,  HttpStatus httpstatus) {
        this.message = message;
       // this.throwable = throwable;
        this.httpstatus = httpstatus;
    }



}
