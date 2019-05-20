package com.vincent.evaluating_system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vincent.evaluating_system.entity.EntityPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IDEA on 2019/4/5
 * User: Vincent
 * Time：13:18
 */
public interface EntityPermissionMapper extends BaseMapper<EntityPermission> {
    List<EntityPermission> getPermListByUserId(@Param("userId") int userId);

    List<EntityPermission> getPermListByRoleId(@Param("roleId") int roleId);

    void saveOrUpdate(@Param("perms") List<EntityPermission> perms);


}

