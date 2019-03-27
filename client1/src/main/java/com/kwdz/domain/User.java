package com.kwdz.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    private String userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_password")
    private String userPassword;
    @Column(name = "user_sex")
    private String userSex;
    @Column(name = "user_tel")
    private String userTel;
    @Column(name = "user_idcard")
    private String userIdcard;
    @Column(name = "room_id")
    private String roomId;
    @Column(name = "user_stata")
    private long userStata;


}
