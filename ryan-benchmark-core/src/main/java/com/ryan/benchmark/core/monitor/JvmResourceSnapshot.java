package com.ryan.benchmark.core.monitor;

/**
 * @ClassName JvmResourceSnapshot
 * @Description TODO
 * @Author ryan
 * @Date 2026/1/9 14:50
 * @Version 1.0
 **/

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

public record JvmResourceSnapshot(
        double cpuUsagePercent,
        long usedHeapMb,
        long maxHeapMb
) {

    public static JvmResourceSnapshot capture() {
        OperatingSystemMXBean osBean =
                (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

        double cpu = osBean.getProcessCpuLoad() * 100;

        Runtime rt = Runtime.getRuntime();
        long used = (rt.totalMemory() - rt.freeMemory()) / (1024 * 1024);
        long max = rt.maxMemory() / (1024 * 1024);

        return new JvmResourceSnapshot(cpu, used, max);
    }
}

