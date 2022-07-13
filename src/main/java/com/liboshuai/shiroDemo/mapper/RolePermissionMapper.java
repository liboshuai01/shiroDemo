package com.liboshuai.shiroDemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liboshuai.shiroDemo.entity.RolePermissionEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: liboshuai
 * @Date: 2022-07-13 18:24
 * @Description: 角色权限mapper
 */
@Repository
public interface RolePermissionMapper extends BaseMapper<RolePermissionEntity> {
}
