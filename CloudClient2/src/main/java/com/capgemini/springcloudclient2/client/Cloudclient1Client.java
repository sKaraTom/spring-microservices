package com.capgemini.springcloudclient2.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * client on cloudclient service
 *
 */
@FeignClient("cloudclient")
public interface Cloudclient1Client {

	@GetMapping("/message")
	String getMessage();
	
}
