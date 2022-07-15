package com.liboshuai.shiroDemo.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liboshuai.shiroDemo.entity.PermissionEntity;
import com.liboshuai.shiroDemo.entity.RolePermissionEntity;
import com.liboshuai.shiroDemo.mapper.PermissionMapper;
import com.liboshuai.shiroDemo.mapper.RolePermissionMapper;
import com.liboshuai.shiroDemo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: liboshuai
 * @Date: 2022-07-13 18:14
 * @Description: 权限
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<String> findByRoleId(List<Integer> roleIds) {
        QueryWrapper<RolePermissionEntity> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.in("role_id", roleIds);
        List<RolePermissionEntity> rolePermissionEntities = rolePermissionMapper.selectList(objectQueryWrapper);
        List<Integer> permissionIdS = rolePermissionEntities.stream().map(RolePermissionEntity::getPermissionId).collect(Collectors.toList());
        List<PermissionEntity> permissionEntities = permissionMapper.selectBatchIds(permissionIdS);
        return permissionEntities.stream().map(PermissionEntity::getPermission).collect(Collectors.toList());
    }
}
