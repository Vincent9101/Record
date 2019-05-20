package com.vincent.evaluating_system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vincent.evaluating_system.dao.EntityRolePermissionMapper;
import com.vincent.evaluating_system.entity.EntityRolePermission;
import com.vincent.evaluating_system.service.EntityRolePermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IDEA on 2019/4/5
 * User: Vincent
 * Time：16:38
 */
@Transactional
@Service
public class EntityRolePermissionServiceImpl extends ServiceImpl<EntityRolePermissionMapper, EntityRolePermission>
        implements EntityRolePermissionService {
}
