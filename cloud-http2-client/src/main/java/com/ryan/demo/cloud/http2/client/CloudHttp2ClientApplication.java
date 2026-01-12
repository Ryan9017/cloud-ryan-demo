package com.ryan.demo.cloud.http2.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.ryan.demo.cloud.http2.client.feign")
public class CloudHttp2ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudHttp2ClientApplication.class, args);
	}

}
