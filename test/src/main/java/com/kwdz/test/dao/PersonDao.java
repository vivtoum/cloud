package com.kwdz.test.dao;

import com.kwdz.test.domain.PersonEntity;
import com.kwdz.test.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * @version 0.0.1
 * @author: huyt
 * @date: 2019/4/3 22:20
 */
public interface PersonDao extends CrudRepository<PersonEntity, String> {

    PersonEntity findByName(String name);

    boolean deleteByName(String name);
}
