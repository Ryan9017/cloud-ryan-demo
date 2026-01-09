package com.ryan.benchmark.core.api;

/**
 * @ClassName BenchmarkRequest
 * @Description TODO
 * @Author ryan
 * @Date 2026/1/9 14:44
 * @Version 1.0
 **/
public record BenchmarkRequest(
        String testType,          // cloud-http / dubbo-rpc / grpc
        String description,       // 测试说明
        int concurrency,          // 并发线程数
        int totalRequests,        // 请求总数
        int rounds                // 测试轮次
) {}

