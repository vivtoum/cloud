package com.kwdz.test.service;

import com.kwdz.test.domain.PersonEntity;

/**
 * @version 0.0.1
 * @author: huyt
 * @date: 2019/4/3 22:33
 */
public interface PersonService {

    public PersonEntity getPersonByName(String name);

    PersonEntity savePerson(PersonEntity person);
}
