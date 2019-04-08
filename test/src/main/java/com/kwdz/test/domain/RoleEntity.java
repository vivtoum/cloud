package com.kwdz.test.domain;

import javax.persistence.*;
import java.util.Objects;

/**
 * @version 0.0.1
 * @author: huyt
 * @date: 2019/4/3 22:02
 */
@Entity
@Table(name = "role", schema = "springbootdemo", catalog = "")
public class RoleEntity {
    private int id;
    private String roleName;
    private int userId;
    private String userUserId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "role_name")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_user_id")
    public String getUserUserId() {
        return userUserId;
    }

    public void setUserUserId(String userUserId) {
        this.userUserId = userUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return id == that.id &&
                userId == that.userId &&
                Objects.equals(roleName, that.roleName) &&
                Objects.equals(userUserId, that.userUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleName, userId, userUserId);
    }
}
