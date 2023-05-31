package com.yash.restcruddemo.exception;

public class CloudVendorAlreadyExistsException extends RuntimeException
{
    private String message;
    public CloudVendorAlreadyExistsException( ) {}
    public CloudVendorAlreadyExistsException(String msg) {
        super(msg);
        this.message = msg;
    }

}
