package com.ryan.demo.cloud.clienta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.ryan.demo.cloud.clienta.feign")
public class CloudClientAApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudClientAApplication.class, args);
	}

}
