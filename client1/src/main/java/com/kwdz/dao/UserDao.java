package com.kwdz.dao;

import com.kwdz.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, String> {

    User findByUserId(String userid);
}
