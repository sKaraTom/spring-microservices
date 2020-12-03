package com.capgemini.springcloudclient.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("cloudclient2")
public interface Cloudclient2Client {

	@GetMapping("/message")
	String getMessage();
}
