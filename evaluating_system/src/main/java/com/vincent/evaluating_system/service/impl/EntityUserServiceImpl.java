package com.vincent.evaluating_system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vincent.evaluating_system.dao.EntityUserMapper;
import com.vincent.evaluating_system.entity.EntityUser;
import com.vincent.evaluating_system.service.EntityUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IDEA on 2019/4/5
 * User: Vincent
 * Time：16:35
 */
@Service
@Transactional
public class EntityUserServiceImpl extends ServiceImpl<EntityUserMapper, EntityUser> implements EntityUserService {
    @Override
    public List<EntityUser> getUserListByRoleId(int roleId) {
        return baseMapper.getUserListByRoleId(roleId);
    }
}
