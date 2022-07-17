package com.liboshuai.shiroDemo.service;

import com.liboshuai.shiroDemo.entity.RoleEntity;
import com.liboshuai.shiroDemo.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: liboshuai
 * @Date: 2022-07-15 17:38
 * @Description: 用户服务接口
 */
@Service
public interface UserService {

    /**
     * 根据用户id查询角色信息
     *
     * @param userId 用户id
     * @return 角色信息
     */
    List<RoleEntity> findRoleByUserId(Integer userId);

    /**
     * 根据用户名称查询用户信息
     *
     * @param username 用户名称
     * @return 用户信息
     */
    UserEntity findByUserName(String username);
}
