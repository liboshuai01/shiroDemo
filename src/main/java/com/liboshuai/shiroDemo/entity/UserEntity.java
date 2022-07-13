package com.liboshuai.shiroDemo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName(value = "user")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = -6056125703075132981L;

    @TableId("id")
    private Integer id;

    @TableField("account")
    private String account;

    @TableField("password")
    private String password;

    @TableField("username")
    private String username;
}
