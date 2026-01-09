package com.ryan.demo.cloud.grpc.clienta.configuration;

import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName GrpcClientFactory
 * @Description TODO
 * @Author ryan
 * @Date 2026/1/9 09:13
 * @Version 1.0
 **/
import java.util.concurrent.ThreadLocalRandom;

//@Component
public class GrpcChannelFactory {

    private final NamingService namingService;

    public GrpcChannelFactory(NamingService namingService) {
        this.namingService = namingService;
    }

    public ManagedChannel createChannel(String serviceName) throws Exception {
        List<Instance> instances =
                namingService.getAllInstances(serviceName);

        if (instances.isEmpty()) {
            throw new IllegalStateException("No available gRPC instance");
        }

        Instance instance = instances.get(
                ThreadLocalRandom.current().nextInt(instances.size())
        );

        return ManagedChannelBuilder
                .forAddress(instance.getIp(), instance.getPort())
                .usePlaintext()
                .build();
    }
}


