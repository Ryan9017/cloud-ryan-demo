package com.ryan.demo.cloud.servera.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName UserDTO
 * @Description TODO
 * @Author ryan
 * @Date 2025/12/31 13:42
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBDTO implements Serializable {
    private Long id;
    private String name;

}
