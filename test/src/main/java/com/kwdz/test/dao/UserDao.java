package com.kwdz.test.dao;

import com.kwdz.test.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * @version 0.0.1
 * @author: huyt
 * @date: 2019/4/3 22:03
 */

public interface UserDao extends CrudRepository<UserEntity, String> {

}
