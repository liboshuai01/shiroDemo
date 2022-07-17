package com.liboshuai.shiroDemo.shiro;

import com.liboshuai.shiroDemo.constants.enums.ServerResponseEnum;
import com.liboshuai.shiroDemo.vo.ServerResponseVO;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: liboshuai
 * @Date: 2022-07-15 16:41
 * @Description: UserExceptionAdvice
 */
@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ServerResponseVO UnAuthorizedExceptionHandler(UnauthorizedException e) {
        return ServerResponseVO.fail(ServerResponseEnum.UNAUTHORIZED);
    }
}
