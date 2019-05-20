package com.vincent.evaluating_system.vo;

/**
 * Created by IDEA on 2019/4/4
 * User: Vincent
 * Time：17:26
 * 用于存储角色或权限的值
 */
public class AuthVO {

    private String desc;//显示名
    private String value;//值

    public AuthVO(String desc, String value) {
        this.desc = desc;
        this.value = value;
    }

    public AuthVO() {
    }

    @Override
    public String toString() {
        return "AuthVO{" +
                "desc='" + desc + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthVO authVo = (AuthVO) o;

        if (desc != null ? !desc.equals(authVo.desc) : authVo.desc != null) return false;
        return value != null ? value.equals(authVo.value) : authVo.value == null;
    }

    @Override
    public int hashCode() {
        int result = desc != null ? desc.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
