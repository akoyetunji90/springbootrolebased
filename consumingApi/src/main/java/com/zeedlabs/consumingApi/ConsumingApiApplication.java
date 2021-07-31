package com.zeedlabs.consumingApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumingApiApplication {

	@Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumingApiApplication.class, args);
	}

}
