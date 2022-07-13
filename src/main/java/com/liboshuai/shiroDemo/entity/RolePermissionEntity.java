package com.liboshuai.shiroDemo.entity;

import io.swagger.models.auth.In;
import lombok.*;

/**
 * @Author: liboshuai
 * @Date: 2022-07-13 18:21
 * @Description: 角色权限实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class RolePermissionEntity {

    private Integer id;

    private Integer roleId;

    private Integer permissionId;
}
