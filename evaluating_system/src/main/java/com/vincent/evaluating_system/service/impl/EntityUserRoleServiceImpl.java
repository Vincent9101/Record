package com.vincent.evaluating_system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vincent.evaluating_system.dao.EntityUserRoleMapper;
import com.vincent.evaluating_system.entity.EntityUserRole;
import com.vincent.evaluating_system.service.EntityUserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IDEA on 2019/4/5
 * User: Vincent
 * Time：16:37
 */
@Service
@Transactional
public class EntityUserRoleServiceImpl extends ServiceImpl<EntityUserRoleMapper, EntityUserRole>
        implements EntityUserRoleService {
}
