package com.liboshuai.shiroDemo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName(value = "role")
public class RoleEntity implements Serializable {
    private static final long serialVersionUID = -1767327914553823741L;

    @TableId("id")
    private Integer id;

    @TableField("role")
    private String role;

    @TableField("description")
    private String description;
}
