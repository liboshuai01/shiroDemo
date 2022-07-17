package com.liboshuai.shiroDemo.shiro;

import com.liboshuai.shiroDemo.entity.RoleEntity;
import com.liboshuai.shiroDemo.entity.UserEntity;
import com.liboshuai.shiroDemo.service.PermissionService;
import com.liboshuai.shiroDemo.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * @Author: liboshuai
 * @Date: 2022-07-15 16:54
 * @Description: shiroRealm
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    /**
     * 授权认证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        UserEntity userEntity = (UserEntity) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        List<RoleEntity> roleEntities = userService.findRoleByUserId(userEntity.getId());
        Set<String> roleSet = new HashSet<>();
        List<Integer> roleIdList = new ArrayList<>();
        roleEntities.forEach(roleEntity -> {
            roleSet.add(roleEntity.getRole());
            roleIdList.add(roleEntity.getId());
        });
        // 放入角色信息
        simpleAuthorizationInfo.setRoles(roleSet);
        // 放入权限信息
        List<String> permissionList = permissionService.findByRoleId(roleIdList);
        simpleAuthorizationInfo.setStringPermissions(new HashSet<>(permissionList));
        return simpleAuthorizationInfo;
    }

    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        UserEntity userEntity = userService.findByUserName(usernamePasswordToken.getUsername());
        if (Objects.isNull(userEntity)) {
            return null;
        }
        return new SimpleAuthenticationInfo(userEntity, userEntity.getPassword(), getName());
    }
}
