package com.vincent.evaluating_system.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IDEA on 2019/4/5
 * User: Vincent
 * Time：12:49
 */
@TableName("table_role")
public class EntityRole extends Model<EntityRole> {

    @TableId(type = IdType.AUTO)
    private int roleId;
    private String roleValue;
    private String roleDesc;
    private Date created;
    private Date updated;

    @Override
    protected Serializable pkVal() {
        return roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityRole that = (EntityRole) o;

        if (roleId != that.roleId) return false;
        if (roleValue != null ? !roleValue.equals(that.roleValue) : that.roleValue != null) return false;
        if (roleDesc != null ? !roleDesc.equals(that.roleDesc) : that.roleDesc != null) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        return updated != null ? updated.equals(that.updated) : that.updated == null;
    }

    @Override
    public int hashCode() {
        int result = roleId;
        result = 31 * result + (roleValue != null ? roleValue.hashCode() : 0);
        result = 31 * result + (roleDesc != null ? roleDesc.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (updated != null ? updated.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EntityRole{" +
                "roleId=" + roleId +
                ", roleValue='" + roleValue + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleValue() {
        return roleValue;
    }

    public void setRoleValue(String roleValue) {
        this.roleValue = roleValue;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
