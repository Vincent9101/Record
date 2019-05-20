package com.vincent.evaluating_system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vincent.evaluating_system.dao.EntityPermissionMapper;
import com.vincent.evaluating_system.entity.EntityPermission;
import com.vincent.evaluating_system.service.EntityPermissionService;
import com.vincent.evaluating_system.vo.AuthVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by IDEA on 2019/4/5
 * User: Vincent
 * Time：16:08
 */

@Service
@Transactional
public class EntityPermissionServiceImpl extends ServiceImpl<EntityPermissionMapper, EntityPermission> implements EntityPermissionService {

    @Override
    public Set<AuthVO> getPermSetByUserId(int userId) {
        return baseMapper.getPermListByUserId(userId)
                .stream()
                .map(entityPermission -> new AuthVO(entityPermission.getPermDesc(), entityPermission.getPermValue()))
                .collect(Collectors.toSet());
    }

    @Override
    public List<EntityPermission> getPermListByRoleId(int roleId) {
        return baseMapper.getPermListByRoleId(roleId);
    }

    @Override
    public void saveOrUpdate(List<EntityPermission> perms) {
        baseMapper.saveOrUpdate(perms);

    }
}
