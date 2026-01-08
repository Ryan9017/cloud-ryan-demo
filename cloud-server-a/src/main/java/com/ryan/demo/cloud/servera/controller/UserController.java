package com.ryan.demo.cloud.servera.controller;

import com.ryan.demo.cloud.servera.dto.UserBDTO;
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
public class UserController {

    @GetMapping("/{id}")
    public UserBDTO getUserById(@PathVariable("id") Long id) {
        return new UserBDTO(id, "provider-user-" + id);
    }
}

