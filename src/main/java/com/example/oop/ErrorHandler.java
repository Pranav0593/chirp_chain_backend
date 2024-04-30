package com.example.oop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ErrorHandler
{

    String errorMesssage;

    public ErrorHandler(String errorMesssage)
    {
        this.errorMesssage = errorMesssage;
    }

    public ResponseEntity<Object> getErrorResponse()
    {
        Map<String, String> response = new HashMap<>();
        response.put("Error", errorMesssage);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public void setErrorMesssage(String errorMesssage)
    {
        this.errorMesssage = errorMesssage;
    }

}
