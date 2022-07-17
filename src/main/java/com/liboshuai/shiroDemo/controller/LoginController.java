package com.liboshuai.shiroDemo.controller;

import com.liboshuai.shiroDemo.constants.enums.ServerResponseEnum;
import com.liboshuai.shiroDemo.vo.ServerResponseVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: liboshuai
 * @Date: 2022-07-17 21:55
 * @Description: 登录controller
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping("/userLogin")
    public ServerResponseVO userLogin(@RequestParam(value = "userName") String userName,
                                      @RequestParam(value = "password") String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, password);
        try {
            subject.login(usernamePasswordToken);
            return ServerResponseVO.success("登录成功");
        } catch (UnknownAccountException e) {
            return ServerResponseVO.fail(ServerResponseEnum.ACCOUNT_NOT_EXIST);
        } catch (DisabledAccountException e) {
            return ServerResponseVO.fail(ServerResponseEnum.ACCOUNT_IS_DISABLED);
        } catch (IncorrectCredentialsException e) {
            return ServerResponseVO.fail(ServerResponseEnum.INCORRECT_CREDENTIALS);
        } catch (Throwable e) {
            e.printStackTrace();
            return ServerResponseVO.fail(ServerResponseEnum.FAIL);
        }
    }

    @GetMapping("/userLogin")
    public ServerResponseVO userLogin() {
        return ServerResponseVO.fail(ServerResponseEnum.NOT_LOGIN_IN);
    }

    @GetMapping("/auth")
    public String auth() {
        return "已成功登录";
    }

    @GetMapping("/role")
    @RequiresRoles("vip")
    public String role() {
        return "测试vip角色";
    }

    @GetMapping("/permission")
    @RequiresPermissions(value = {"add", "update"}, logical = Logical.AND)
    public String permission() {
        return "测试Add和Update权限";
    }

}
