package com.ryan.demo.cloud.grpc.clienta.configuration;

/**
 * @ClassName NacosNamingConfiguration
 * @Description TODO
 * @Author ryan
 * @Date 2026/1/9 09:20
 * @Version 1.0
 **/
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.naming.NamingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class NacosNamingConfiguration {

    @Value("${spring.cloud.nacos.discovery.server-addr}")
    private String serverAddr;

    @Bean
    public NamingService namingService() throws Exception {
        Properties properties = new Properties();
        properties.put("serverAddr", serverAddr);
        return NacosFactory.createNamingService(properties);
    }
}

