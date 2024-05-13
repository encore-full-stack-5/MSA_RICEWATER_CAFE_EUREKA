package com.example.cafe_eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CafeEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CafeEurekaApplication.class, args);
	}

}
