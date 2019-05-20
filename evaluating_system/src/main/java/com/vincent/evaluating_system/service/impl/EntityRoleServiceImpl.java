package com.vincent.evaluating_system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vincent.evaluating_system.dao.EntityRoleMapper;
import com.vincent.evaluating_system.entity.EntityRole;
import com.vincent.evaluating_system.service.EntityRoleService;
import com.vincent.evaluating_system.vo.AuthVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by IDEA on 2019/4/5
 * User: Vincent
 * Time：16:24
 */

@Service
@Transactional
public class EntityRoleServiceImpl extends ServiceImpl<EntityRoleMapper, EntityRole> implements EntityRoleService {
    @Override
    public Set<AuthVO> getRoleSetByUserId(int userId) {
        return baseMapper.getRoleListByUserId(userId)
                .stream()
                .map(entityRole -> new AuthVO(entityRole.getRoleDesc(), entityRole.getRoleValue()))
                .collect(Collectors.toSet());
    }




}
