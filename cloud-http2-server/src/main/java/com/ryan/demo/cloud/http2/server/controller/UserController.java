package com.ryan.demo.cloud.http2.server.controller;

import com.ryan.demo.cloud.http2.server.dto.UserBDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author ryan
 * @Date 2026/1/8 10:12
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {

    @GetMapping("/{id}")
    public UserBDTO getUserById(@PathVariable("id") Long id) {
        UserBDTO userBDTO = new UserBDTO(id, "provider-user-" + id);
//        log.info("-----");
        return userBDTO;
    }
}

