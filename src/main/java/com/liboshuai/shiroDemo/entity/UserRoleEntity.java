package com.liboshuai.shiroDemo.entity;

import lombok.*;

/**
 * @Author: liboshuai
 * @Date: 2022-07-13 18:22
 * @Description: 用户校色表实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserRoleEntity {

    private Integer id;

    private Integer userId;

    private Integer roleId;
}
