package com.liboshuai.shiroDemo.entity;

import lombok.*;

import java.io.Serializable;

/**
 * @Author: liboshuai
 * @Date: 2022-07-13 17:47
 * @Description: 用户实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserEntity implements Serializable {
    private static final long serialVersionUID = -6056125703075132981L;

    private Integer id;

    private String account;

    private String password;

    private String username;
}
