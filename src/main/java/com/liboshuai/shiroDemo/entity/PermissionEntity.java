package com.liboshuai.shiroDemo.entity;

import lombok.*;

import java.io.Serializable;

/**
 * @Author: liboshuai
 * @Date: 2022-07-13 17:50
 * @Description: 权限实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PermissionEntity implements Serializable {

    private static final long serialVersionUID = -1767327914553823742L;

    private Integer id;

    private String permission;

    private String desc;
}
