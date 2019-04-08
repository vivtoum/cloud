package com.kwdz.test.service;

import com.kwdz.test.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 0.0.1
 * @author: huyt
 * @date: 2019/4/3 22:12
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


}
