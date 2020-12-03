package com.capgemini.springcloudclient2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableFeignClients
@RefreshScope
public class Cloudclient2Application {

    @Value("${message}")
    private String message;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Cloudclient2Application.class, args);
	}
	
	 @GetMapping(value = "/showConfig",  
      produces = MediaType.TEXT_PLAIN_VALUE)
    public String showConfig() {
        return message;
    }

}
