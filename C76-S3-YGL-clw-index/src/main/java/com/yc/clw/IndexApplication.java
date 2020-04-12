package com.yc.clw;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@MapperScan("com.yc.clw")
//开启远程服务调用
@EnableFeignClients
public class IndexApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(IndexApplication.class, args);
	}
}
