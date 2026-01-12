package com.ryan.demo.cloud.http2.nonacos.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.ryan.demo.cloud.http2.nonacos.client.feign")
public class CloudHttp2NonacosClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudHttp2NonacosClientApplication.class, args);
	}

}
