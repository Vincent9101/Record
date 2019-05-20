package com.vincent.evaluating_system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vincent.evaluating_system.entity.EntityRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IDEA on 2019/4/5
 * User: Vincent
 * Time：15:29
 */
public interface EntityRoleMapper extends BaseMapper<EntityRole> {
    List<EntityRole> getRoleListByUserId(@Param("userId")int userId);

}
