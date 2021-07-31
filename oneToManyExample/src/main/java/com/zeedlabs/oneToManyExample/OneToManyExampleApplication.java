package com.zeedlabs.oneToManyExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OneToManyExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneToManyExampleApplication.class, args);
	}

}
