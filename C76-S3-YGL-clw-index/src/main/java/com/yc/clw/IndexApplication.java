package com.yc.clw;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


@SpringBootApplication
//MyBatis 接口组件扫描
@MapperScan("com.yc.clw")
//开启声明式远程服务调用
@EnableFeignClients
//spirng 回话共享注解
@EnableRedisHttpSession
public class IndexApplication {

	public static void main(String[] args) {
		SpringApplication.run(IndexApplication.class, args);
	}
}
