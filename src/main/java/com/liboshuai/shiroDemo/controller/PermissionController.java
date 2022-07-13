package com.liboshuai.shiroDemo.controller;

import com.liboshuai.shiroDemo.service.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: liboshuai
 * @Date: 2022-07-13 18:34
 * @Description: 权限controller类
 */
@RestController
@RequestMapping("/permission")
@Api(value = "权限controller")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @ApiOperation(value = "根据角色id查询权限名", httpMethod = "POST")
    @PostMapping("/findByRoleId")
    public List<String> findByRoleId(@RequestBody List<Integer> roleIds) {
        return permissionService.findByRoleId(roleIds);
    }
}
