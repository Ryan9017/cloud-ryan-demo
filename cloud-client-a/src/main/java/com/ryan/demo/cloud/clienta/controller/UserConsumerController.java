package com.ryan.demo.cloud.clienta.controller;

import com.ryan.demo.cloud.clienta.dto.UserBDTO;
import com.ryan.demo.cloud.clienta.feign.UserFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserConsumerController
 * @Description TODO
 * @Author ryan
 * @Date 2026/1/8 10:21
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/consumer/user")
public class UserConsumerController {

    private final UserFeignClient userFeignClient;

    public UserConsumerController(UserFeignClient userFeignClient) {
        this.userFeignClient = userFeignClient;
    }

    @GetMapping("/{id}")
    public UserBDTO getUser(@PathVariable("id") Long id) {
        return userFeignClient.getUserById(id);
    }
}

