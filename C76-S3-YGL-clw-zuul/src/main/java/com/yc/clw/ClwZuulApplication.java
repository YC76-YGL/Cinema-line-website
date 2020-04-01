package com.yc.clw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ClwZuulApplication {
	public static void main(String[] args) {
		SpringApplication.run(ClwZuulApplication.class, args);
	}
}