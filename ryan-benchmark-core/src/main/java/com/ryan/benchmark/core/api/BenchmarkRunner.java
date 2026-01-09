
package com.ryan.benchmark.core.api;



import com.ryan.benchmark.core.monitor.JvmResourceSnapshot;
import com.ryan.benchmark.core.util.BenchmarkLogger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public final class BenchmarkRunner {

    private BenchmarkRunner() {}

    public static BenchmarkResult run(
            BenchmarkRequest request,
            Runnable task
    ) throws Exception {

        BenchmarkLogger.logRequest(request);

        int concurrency = request.concurrency();
        int totalRequests = request.totalRequests();

        ExecutorService executor = Executors.newFixedThreadPool(concurrency);
        CountDownLatch latch = new CountDownLatch(totalRequests);

        List<Long> latencies = Collections.synchronizedList(new ArrayList<>());

        JvmResourceSnapshot before = JvmResourceSnapshot.capture();

        long startNs = System.nanoTime();

        for (int i = 0; i < totalRequests; i++) {
            executor.submit(() -> {
                long begin = System.nanoTime();
                try {
                    task.run();
                } finally {
                    long cost = System.nanoTime() - begin;
                    latencies.add(cost);
                    latch.countDown();
                }
            });
        }

        latch.await();
        long endNs = System.nanoTime();
        executor.shutdown();

        JvmResourceSnapshot after = JvmResourceSnapshot.capture();

        long totalTimeMs = (endNs - startNs) / 1_000_000;
        double qps = totalRequests / (totalTimeMs / 1000.0);

        List<Long> sorted = new ArrayList<>(latencies);
        sorted.sort(Long::compareTo);

        long avgMs = sorted.stream().mapToLong(v -> v).sum()
                / sorted.size() / 1_000_000;

        long p95Ms = sorted.get((int) (sorted.size() * 0.95)) / 1_000_000;
        long p99Ms = sorted.get((int) (sorted.size() * 0.99)) / 1_000_000;

        BenchmarkResult result = new BenchmarkResult(
                request.testType(),
                concurrency,
                totalRequests,
                totalTimeMs,
                qps,
                avgMs,
                p95Ms,
                p99Ms,
                after.cpuUsagePercent(),
                after.usedHeapMb(),
                after.maxHeapMb()
        );

        BenchmarkLogger.logResult(result);

        return result;
    }
}



