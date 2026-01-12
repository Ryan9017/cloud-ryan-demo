package com.ryan.demo.cloud.http2.nonacos.client.configuration;

/**
 * @ClassName FeignOkHttpClientConfig
 * @Description TODO
 * @Author ryan
 * @Date 2026/1/12 15:55
 * @Version 1.0
 **/
import feign.Client;
import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignOkHttpClientConfig {

    @Bean
    public Client feignClient(okhttp3.OkHttpClient rawOkHttpClient) {
        return new OkHttpClient(rawOkHttpClient);
    }
}

