package com.vincent.evaluating_system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vincent.evaluating_system.entity.EntityUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IDEA on 2019/4/5
 * User: Vincent
 * Time：15:39
 */
public interface EntityUserMapper extends BaseMapper<EntityUser> {
    List<EntityUser> getUserListByRoleId(@Param("roleId") int roleId);
}
