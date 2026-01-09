package com.ryan.demo.cloud.grpc.clienta.controller;

import com.ryan.demo.cloud.grpc.clienta.service.GreeterServicGrpc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName CloudClientController
 * @Description TODO
 * @Author ryan
 * @Date 2026/1/9 09:30
 * @Version 1.0
 **/
@RestController
public class CloudClientController {

    private final GreeterServicGrpc greeterServicGrpc;

    public CloudClientController(GreeterServicGrpc greeterServicGrpc) {
        this.greeterServicGrpc = greeterServicGrpc;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name) throws Exception {
        return greeterServicGrpc.sayHello(name);
    }

}
