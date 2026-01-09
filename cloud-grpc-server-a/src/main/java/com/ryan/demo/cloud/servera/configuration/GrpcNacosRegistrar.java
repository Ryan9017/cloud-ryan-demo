package com.ryan.demo.cloud.servera.configuration;

import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.util.Map;

/**
 * @ClassName GrpcNacosRegistrar
 * @Description TODO
 * @Author ryan
 * @Date 2026/1/9 09:07
 * @Version 1.0
 **/
@Component
public class GrpcNacosRegistrar implements ApplicationRunner {

    @Autowired
    private NamingService namingService;

    @Value("${spring.application.name}")
    private String serviceName;

    @Value("${grpc.server.port}")
    private int grpcPort;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Instance instance = new Instance();
        instance.setIp(InetAddress.getLocalHost().getHostAddress());
        instance.setPort(grpcPort);
        instance.setHealthy(true);
        instance.setMetadata(Map.of("protocol", "grpc"));

        namingService.registerInstance(serviceName, instance);
    }
}

