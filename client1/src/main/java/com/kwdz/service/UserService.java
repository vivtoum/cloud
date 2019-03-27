package com.kwdz.service;


import com.kwdz.domain.User;

public interface UserService {
    User findByUserId(String userid);
}
