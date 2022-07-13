package com.liboshuai.shiroDemo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName(value = "user_role")
public class UserRoleEntity {

    @TableId("id")
    private Integer id;

    @TableField("user_id")
    private Integer userId;

    @TableField("role_id")
    private Integer roleId;
}
