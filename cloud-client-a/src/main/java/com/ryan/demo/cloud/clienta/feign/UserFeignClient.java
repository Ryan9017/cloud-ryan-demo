package com.ryan.demo.cloud.clienta.feign;

import com.ryan.demo.cloud.clienta.dto.UserBDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName UserFeignClient
 * @Description TODO
 * @Author ryan
 * @Date 2026/1/8 10:20
 * @Version 1.0
 **/
@FeignClient(name = "cloud-server-a")
public interface UserFeignClient {

    @GetMapping("/api/user/{id}")
    UserBDTO getUserById(@PathVariable("id") Long id);
}

