package com.liboshuai.shiroDemo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName(value = "role_permission")
public class RolePermissionEntity {

    @TableId(value = "id")
    private Integer id;

    @TableField("role_id")
    private Integer roleId;

    @TableField("permission_id")
    private Integer permissionId;
}
