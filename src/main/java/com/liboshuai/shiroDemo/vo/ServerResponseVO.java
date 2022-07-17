package com.liboshuai.shiroDemo.vo;

import com.liboshuai.shiroDemo.constants.enums.ServerResponseEnum;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: liboshuai
 * @Date: 2022-07-15 16:11
 * @Description: 服务响应vo对象
 */
@Data
@NoArgsConstructor
@Builder
public class ServerResponseVO<T> implements Serializable {

    private static final long serialVersionUID = -1986870122406239798L;

    // 响应码
    private Integer code;

    // 响应描述
    private String message;

    // 响应内容
    private T data;

    private ServerResponseVO(ServerResponseEnum serverResponseEnum) {
        this.code = serverResponseEnum.getCode();
        this.message = serverResponseEnum.getMessage();
    }

    private ServerResponseVO(ServerResponseEnum serverResponseEnum, T data) {
        this.code = serverResponseEnum.getCode();
        this.message = serverResponseEnum.getMessage();
        this.data = data;
    }

    private ServerResponseVO(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static<T> ServerResponseVO<T> success() {
        return new ServerResponseVO<>(ServerResponseEnum.SUCCESS);
    }

    public static<T> ServerResponseVO<T> success(T data) {
        return new ServerResponseVO<>(ServerResponseEnum.SUCCESS, data);
    }

    public static<T> ServerResponseVO<T> success(Integer code, String message, T data) {
        return new ServerResponseVO<>(code, message, data);
    }

    public static<T> ServerResponseVO<T> fail(ServerResponseEnum serverResponseEnum) {
        return new ServerResponseVO<>(serverResponseEnum);
    }
}
