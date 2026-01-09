package com.ryan.benchmark.core.api;

/**
 * @ClassName BenchmarkResult
 * @Description TODO
 * @Author ryan
 * @Date 2026/1/9 14:45
 * @Version 1.0
 **/
public record BenchmarkResult(
        String testType,                // 测试类型
        int concurrency,                // 并发线程数
        int totalRequests,              // 请求总数

        long totalTimeMs,               // 总耗时(ms)
        double throughputQps,           // 吞吐量(QPS)

        long avgLatencyMs,              // 平均响应时间(ms)
        long p95LatencyMs,              // P95 延迟(ms)
        long p99LatencyMs,              // P99 延迟(ms)

        double cpuUsagePercent,         // CPU 使用率(%)
        long usedHeapMb,                // 已用堆内存(MB)
        long maxHeapMb                  // 最大堆内存(MB)
) {}

