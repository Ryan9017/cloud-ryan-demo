package com.ryan.demo.cloud.grpc.clienta.controller;

import com.ryan.benchmark.core.api.BenchmarkRequest;
import com.ryan.benchmark.core.api.BenchmarkRunner;
import com.ryan.demo.cloud.grpc.clienta.service.GreeterServicGrpc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BenchmarkController
 * @Description TODO
 * @Author ryan
 * @Date 2026/1/9 15:07
 * @Version 1.0
 **/
@RestController
@Slf4j
public class BenchmarkController {

    private final GreeterServicGrpc greeterServicGrpc;

    public BenchmarkController(GreeterServicGrpc greeterServicGrpc) {
        this.greeterServicGrpc = greeterServicGrpc;
    }

    @GetMapping("/benchmark")
    public String benchmark(){
        try {
            BenchmarkRunner.run(
                    new BenchmarkRequest(
                            "cloud-grpc",
                            "Cloud gRPC 本地性能测试",
                            100,
                            10_000,
                            1
                    ),
                    () -> {
                        try {
                            greeterServicGrpc.sayHello("Cloud gRPC");
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
            );
        } catch (Exception e) {
            log.error("e:{}",e);
            return "Cloud gRPC benchmark has error!";
        }
        return "Cloud gRPC benchmark success!";

    }
}
