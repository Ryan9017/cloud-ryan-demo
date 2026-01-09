package com.ryan.demo.cloud.grpc.clienta.service;

/**
 * @ClassName GrpcChannelFactory
 * @Description TODO
 * @Author ryan
 * @Date 2026/1/9 15:25
 * @Version 1.0
 **/

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class GrpcChannelFactory {

    private static final Map<String, ManagedChannel> CHANNEL_CACHE = new ConcurrentHashMap<>();

    /**
     * 基于 serviceName 获取 Channel（强制复用）
     */
    public static ManagedChannel getChannel(String serviceName) {
        return CHANNEL_CACHE.computeIfAbsent(serviceName, key -> {
            return ManagedChannelBuilder
                    // Cloud gRPC / Nacos / Consul / k8s
                    .forTarget("discovery:///" + serviceName)
                    .usePlaintext()   // benchmark 本地测试
                    .build();
        });
    }

    /**
     * JVM 关闭时调用
     */
    public static void shutdownAll() {
        CHANNEL_CACHE.values().forEach(channel -> {
            if (!channel.isShutdown()) {
                channel.shutdown();
            }
        });
    }
}


