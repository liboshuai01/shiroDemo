package com.liboshuai.shiroDemo.constants.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: liboshuai
 * @Date: 2022-07-15 16:07
 * @Description: 服务响应枚举
 */
@Getter
@AllArgsConstructor
public enum ServerResponseEnum {
    SUCCESS(0, "成功"),
    FAIL(10,"失败"),
    ACCOUNT_NOT_EXIST(11, "账号不存在"),
    DUPLICATE_ACCOUNT(12, "账号重复"),
    ACCOUNT_IS_DISABLED(13, "账号被禁用"),
    INCORRECT_CREDENTIALS(14, "账号或密码错误"),
    NOT_LOGIN_IN(15, "账号未登录"),
    UNAUTHORIZED(16, "没有权限")
    ;

    private final Integer code;
    private final String message;
}
