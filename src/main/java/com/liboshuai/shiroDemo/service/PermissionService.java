package com.liboshuai.shiroDemo.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: liboshuai
 * @Date: 2022-07-13 18:01
 * @Description: 权限服务接口
 */
@Service
public interface PermissionService {

    List<String> findByRoleId(List<Integer> roleIds);
}
