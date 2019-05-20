package com.vincent.evaluating_system.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * Created by IDEA on 2019/4/5
 * User: Vincent
 * Time：13:12
 */
@TableName("table_user_role")
public class EntityUserRole implements Serializable {
    @TableField("user_id")
    private int userId;
    @TableField("role_id")
    private int roleId;

    @Override
    public String toString() {
        return "EntityUserRole{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityUserRole that = (EntityUserRole) o;

        if (userId != that.userId) return false;
        return roleId == that.roleId;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + roleId;
        return result;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
