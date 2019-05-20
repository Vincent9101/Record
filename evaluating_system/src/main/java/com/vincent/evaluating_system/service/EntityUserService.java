package com.vincent.evaluating_system.service;

import com.baomidou.mybatisplus.service.IService;
import com.vincent.evaluating_system.entity.EntityUser;

import java.util.List;

/**
 * Created by IDEA on 2019/4/5
 * User: Vincent
 * Time：16:05
 */
public interface EntityUserService extends IService<EntityUser> {
    List<EntityUser> getUserListByRoleId(int roleId);
}
