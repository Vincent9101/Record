package com.vincent.evaluating_system.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * Created by IDEA on 2019/4/5
 * User: Vincent
 * Time：13:06
 */
@TableName("table_role_permission")
public class EntityRolePermission implements Serializable {

    @TableField("role_id")
    private int roleId;
    @TableField("perm_id")
    private int permId;

    @Override
    public String toString() {
        return "EntityRolePermission{" +
                "roleId=" + roleId +
                ", permId=" + permId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityRolePermission that = (EntityRolePermission) o;

        if (roleId != that.roleId) return false;
        return permId == that.permId;
    }

    @Override
    public int hashCode() {
        int result = roleId;
        result = 31 * result + permId;
        return result;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getPermId() {
        return permId;
    }

    public void setPermId(int permId) {
        this.permId = permId;
    }
}
