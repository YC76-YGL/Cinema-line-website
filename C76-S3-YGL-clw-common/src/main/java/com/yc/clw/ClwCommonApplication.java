package com.yc.clw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//MyBatis 接口组件扫描
@MapperScan("com.yc.ebuy")
public class ClwCommonApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ClwCommonApplication.class, args);
	}
}
