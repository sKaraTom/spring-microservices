package com.capgemini.springcloudclient2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springcloudclient2.client.Cloudclient1Client;
import com.netflix.discovery.EurekaClient;

@RefreshScope
@RestController
public class MessageController {

    @Value("${message}")
    private String message;
    
    @Value("${spring.application.name}")
    private String appName;
	
	@Autowired
	private Cloudclient1Client cloudClient;
	
   @Autowired
    @Lazy
    private EurekaClient eurekaClient;
	
   @GetMapping("/greeting")
   public String greeting() {
       return String.format("Hello from '%s'!", eurekaClient.getApplication(appName).getName());
   }
   
	@GetMapping("/message")
	public String getMessage() {
		return message;
	}
	
	@GetMapping("/cloudclient1/message")
	public String getClientMessage() {
		return cloudClient.getMessage();
	}
	
	@GetMapping("/badrequest")
	public ResponseEntity<String> getBadRequest() {
		return ResponseEntity.badRequest().body("bad request message");
	}
	
	
}
