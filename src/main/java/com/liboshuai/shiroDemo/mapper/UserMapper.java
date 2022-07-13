package com.liboshuai.shiroDemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liboshuai.shiroDemo.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * @Author: liboshuai
 * @Date: 2022-07-13 18:00
 * @Description: 用户mapper
 */
@Repository
public interface UserMapper extends BaseMapper<UserEntity> {
}
