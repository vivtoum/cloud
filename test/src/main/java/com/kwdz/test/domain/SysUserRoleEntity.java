package com.kwdz.test.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @version 0.0.1
 * @author: huyt
 * @date: 2019/4/3 22:02
 */
@Entity
@Table(name = "sys_user_role", schema = "springbootdemo", catalog = "")
public class SysUserRoleEntity {
    private long roleId;
    private long uid;

    @Basic
    @Column(name = "role_id")
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "uid")
    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysUserRoleEntity that = (SysUserRoleEntity) o;
        return roleId == that.roleId &&
                uid == that.uid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, uid);
    }
}
