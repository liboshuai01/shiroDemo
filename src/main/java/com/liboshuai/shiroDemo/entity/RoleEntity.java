package com.liboshuai.shiroDemo.entity;

import lombok.*;

import java.io.Serializable;

/**
 * @Author: liboshuai
 * @Date: 2022-07-13 17:48
 * @Description: 角色实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class RoleEntity implements Serializable {
    private static final long serialVersionUID = -1767327914553823741L;

    private Integer id;

    private String role;

    private String desc;
}
