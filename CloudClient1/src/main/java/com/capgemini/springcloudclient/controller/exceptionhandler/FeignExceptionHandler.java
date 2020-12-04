package com.capgemini.springcloudclient.controller.exceptionhandler;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import feign.FeignException;

@RestControllerAdvice
public class FeignExceptionHandler {

//	@ExceptionHandler(FeignException.BadRequest.class)  
//    public Map<String, Object> handleFeignStatusException(FeignException e, HttpServletResponse response) {
//        response.setStatus(e.status());
//        return new JSONObject(e.contentUTF8()).toMap(); 
//    }
	
	@ExceptionHandler(FeignException.class)  
    public ResponseEntity<Object> handleFeignException(FeignException e, HttpServletResponse response) {
//        response.setStatus(e.status());
//        JSONObject body = new JSONObject(e.contentUTF8());
        return new ResponseEntity<>(e.contentUTF8(), HttpStatus.valueOf(e.status()));
//        return new JSONObject(e.contentUTF8()).toMap(); 
    }
}
