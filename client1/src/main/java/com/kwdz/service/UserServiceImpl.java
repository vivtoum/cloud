package com.kwdz.service;

import com.kwdz.dao.UserDao;
import com.kwdz.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;

    @Override
    public User findByUserId(String userid) {
        return dao.findByUserId(userid);
    }
}
