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
 * Time：12:44
 */
@TableName("table_permission")
public class EntityPermission extends Model<EntityPermission> {

    @TableId(type = IdType.AUTO)
    private int permId;    // 权限值，shiro的权限控制表达式
    private String permValue;   // 权限名称
    private String permDesc;//权限描述
    private Date created;   // 创建时间
    private Date updated;   // 修改时间


    @Override
    protected Serializable pkVal() {
        return permId;
    }

    public EntityPermission() {
    }

    public EntityPermission(String permValue, String permDesc, Date created) {
        this.permValue = permValue;
        this.permDesc = permDesc;
        this.created = created;
    }

    @Override
    public String toString() {
        return "EntityPermission{" +
                "permId=" + permId +
                ", permValue='" + permValue + '\'' +
                ", permDesc='" + permDesc + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityPermission that = (EntityPermission) o;

        if (permId != that.permId) return false;
        if (permValue != null ? !permValue.equals(that.permValue) : that.permValue != null) return false;
        if (permDesc != null ? !permDesc.equals(that.permDesc) : that.permDesc != null) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        return updated != null ? updated.equals(that.updated) : that.updated == null;
    }

    @Override
    public int hashCode() {
        int result = permId;
        result = 31 * result + (permValue != null ? permValue.hashCode() : 0);
        result = 31 * result + (permDesc != null ? permDesc.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (updated != null ? updated.hashCode() : 0);
        return result;
    }

    public String getPermDesc() {
        return permDesc;
    }

    public void setPermDesc(String permDesc) {
        this.permDesc = permDesc;
    }


    public int getPermId() {
        return permId;
    }

    public void setPermId(int permId) {
        this.permId = permId;
    }

    public String getPermValue() {
        return permValue;
    }

    public void setPermValue(String permValue) {
        this.permValue = permValue;
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
