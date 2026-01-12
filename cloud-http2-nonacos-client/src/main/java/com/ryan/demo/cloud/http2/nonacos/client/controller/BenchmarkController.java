package com.ryan.demo.cloud.http2.nonacos.client.controller;

import com.ryan.benchmark.core.api.BenchmarkRequest;
import com.ryan.benchmark.core.api.BenchmarkRunner;
import com.ryan.demo.cloud.http2.nonacos.client.dto.UserBDTO;
import com.ryan.demo.cloud.http2.nonacos.client.feign.UserFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BenchmarkController
 * @Description TODO
 * @Author ryan
 * @Date 2026/1/9 15:02
 * @Version 1.0
 **/
@RestController
@Slf4j
public class BenchmarkController {
    private final UserFeignClient userFeignClient;

    public BenchmarkController(UserFeignClient userFeignClient) {
        this.userFeignClient = userFeignClient;
    }

    @GetMapping("/benchmark")
    public String benchmark(){
        try {
            BenchmarkRunner.run(
                    new BenchmarkRequest(
                            "cloud-http2",
                            "Cloud HTTP2 本地性能测试",
                            100,
                            10_000,
                            1
                    ),
                    () ->
                    {
                        try {
                            UserBDTO userById = userFeignClient.getUserById(1L);
//                            log.info("------{}",userById.getName());
                        }catch (Exception e){
                            log.error("error msg: {}",e.getMessage());
                        }
                    }
            );
        } catch (Exception e) {
            log.error("e:{}",e);
            return "Cloud HTTP2 benchmark has error!";
        }
        return "Cloud HTTP2 benchmark success!";

    }

}
