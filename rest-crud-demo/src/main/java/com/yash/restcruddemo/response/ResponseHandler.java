package com.yash.restcruddemo.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler
{
    public static ResponseEntity<Object> resposeBuilder(
            String message, HttpStatus httpsstatus,Object responseObject)
    {
        Map<String,Object> response = new HashMap<>();
        response.put("message",message);
        response.put("httpsStatus",httpsstatus);
        response.put("data",responseObject);
        return  new ResponseEntity<>(response,httpsstatus);
    }
}
