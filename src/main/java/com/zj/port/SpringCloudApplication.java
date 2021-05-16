package com.zj.port;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SpringCloudApplication {

	public static void main(String[] args) {
		System.out.println("Hello World");
		SpringApplication.run(SpringCloudApplication.class, args);
	}

}
