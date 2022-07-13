package com.liboshuai.shiroDemo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName(value = "permission")
public class PermissionEntity implements Serializable {

    private static final long serialVersionUID = -1767327914553823742L;

    @TableId("id")
    private Integer id;

    @TableField("permission")
    private String permission;

    @TableField("description")
    private String description;
}
