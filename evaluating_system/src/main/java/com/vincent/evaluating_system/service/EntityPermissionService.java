package com.vincent.evaluating_system.service;

import com.baomidou.mybatisplus.service.IService;
import com.vincent.evaluating_system.entity.EntityPermission;
import com.vincent.evaluating_system.vo.AuthVO;

import java.util.List;
import java.util.Set;

/**
 * Created by IDEA on 2019/4/5
 * User: Vincent
 * Time：15:55
 */
public interface EntityPermissionService extends IService<EntityPermission> {
    Set<AuthVO> getPermSetByUserId(int userId);

    List<EntityPermission> getPermListByRoleId(int roleId);

    void saveOrUpdate(List<EntityPermission> perms);
}
