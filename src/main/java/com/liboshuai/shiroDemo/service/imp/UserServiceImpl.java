package com.liboshuai.shiroDemo.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liboshuai.shiroDemo.entity.RoleEntity;
import com.liboshuai.shiroDemo.entity.UserEntity;
import com.liboshuai.shiroDemo.entity.UserRoleEntity;
import com.liboshuai.shiroDemo.mapper.RoleMapper;
import com.liboshuai.shiroDemo.mapper.UserMapper;
import com.liboshuai.shiroDemo.mapper.UserRoleMapper;
import com.liboshuai.shiroDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: liboshuai
 * @Date: 2022-07-15 17:38
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<RoleEntity> findRoleByUserId(Integer userId) {
        QueryWrapper<UserRoleEntity> userRoleEntityQueryWrapper = new QueryWrapper<>();
        userRoleEntityQueryWrapper.eq("user_id", userRoleEntityQueryWrapper);
        List<UserRoleEntity> userRoleEntities = userRoleMapper.selectList(userRoleEntityQueryWrapper);
        List<Integer> roleIds = userRoleEntities.stream().map(UserRoleEntity::getRoleId).collect(Collectors.toList());
        return roleMapper.selectBatchIds(roleIds);
    }

    @Override
    public UserEntity findByUserName(String username) {
        QueryWrapper<UserEntity> userEntityQueryWrapper = new QueryWrapper<>();
        userEntityQueryWrapper.eq("username", userEntityQueryWrapper);
        return userMapper.selectOne(userEntityQueryWrapper);
    }
}
