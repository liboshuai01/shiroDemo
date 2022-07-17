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

    /**
     * 根据角色id批量获取权限信息
     *
     * @param roleIds 角色id集合
     * @return 权限信息集合
     */
    List<String> findByRoleId(List<Integer> roleIds);
}
