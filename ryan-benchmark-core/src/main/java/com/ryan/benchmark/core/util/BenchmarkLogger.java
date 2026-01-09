package com.ryan.benchmark.core.util;

import com.ryan.benchmark.core.api.BenchmarkRequest;
import com.ryan.benchmark.core.api.BenchmarkResult;

/**
 * @ClassName BenchmarkLogger
 * @Description TODO
 * @Author ryan
 * @Date 2026/1/9 14:58
 * @Version 1.0
 **/


public final class BenchmarkLogger {

    private BenchmarkLogger() {}

    public static void logRequest(BenchmarkRequest request) {
        System.out.println("\n========== Benchmark 入参 ==========");
        System.out.println("测试类型       ：" + request.testType());
        System.out.println("测试说明       ：" + request.description());
        System.out.println("并发线程数     ：" + request.concurrency());
        System.out.println("请求总数       ：" + request.totalRequests());
        System.out.println("====================================\n");
    }

    public static void logResult(BenchmarkResult r) {
        System.out.println("\n========== Benchmark 测试结果 ==========");
        System.out.println("测试类型       ：" + r.testType());
        System.out.println("并发线程数     ：" + r.concurrency());
        System.out.println("请求总数       ：" + r.totalRequests());
        System.out.println("总耗时(ms)     ：" + r.totalTimeMs());
        System.out.println("吞吐量(QPS)    ：" + String.format("%.2f", r.throughputQps()));
        System.out.println("平均延迟(ms)   ：" + r.avgLatencyMs());
        System.out.println("P95 延迟(ms)   ：" + r.p95LatencyMs());
        System.out.println("P99 延迟(ms)   ：" + r.p99LatencyMs());
        System.out.println("CPU 使用率(%)  ：" + String.format("%.2f", r.cpuUsagePercent()));
        System.out.println("已用堆内存(MB) ：" + r.usedHeapMb());
        System.out.println("最大堆内存(MB) ：" + r.maxHeapMb());
        System.out.println("========================================\n");
    }
}

