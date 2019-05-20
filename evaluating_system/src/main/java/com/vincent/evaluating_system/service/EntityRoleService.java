package com.vincent.evaluating_system.service;

import com.baomidou.mybatisplus.service.IService;
import com.vincent.evaluating_system.entity.EntityRole;
import com.vincent.evaluating_system.vo.AuthVO;

import java.util.Set;

/**
 * Created by IDEA on 2019/4/5
 * User: Vincent
 * Time：16:01
 */
public interface EntityRoleService extends IService<EntityRole> {

    Set<AuthVO> getRoleSetByUserId(int userId);


}
