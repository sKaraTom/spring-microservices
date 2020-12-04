package com.capgemini.springcloudclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springcloudclient.client.Cloudclient2Client;
import com.netflix.discovery.EurekaClient;


@RefreshScope
@RestController
public class MessageController {

	
    // read copyright from cloud config repo
    @Value("${copyright: default copyright}")
    private String copyright;
    
    @Value("${message}")
    private String message;
    
    @Value("${spring.application.name}")
    private String appName;
    
    @Autowired
    @Lazy
    private EurekaClient eurekaClient;
	
    @Autowired
    private Cloudclient2Client client;

    @GetMapping("/message")
    public String getMessage() {
    	return message;
    }
    
    @GetMapping("/greeting")
    public String greeting() {
        return String.format("Hello from '%s'!", eurekaClient.getApplication(appName).getName());
    }
    
    @GetMapping("/client2/message")
    public String getClientMessage() {
    	return client.getMessage();
    }
    
	@GetMapping("/client2/badrequest")
	public ResponseEntity<String> getBadRequest() {
		return client.getBadRequest();
	}
    
}
