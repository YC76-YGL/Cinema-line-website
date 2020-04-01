package com.yc.clw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ClwServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClwServerApplication.class, args);
	}
}
