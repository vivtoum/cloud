package com.kwdz.test.service;

import com.kwdz.test.dao.PersonDao;
import com.kwdz.test.domain.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author <a href="zhangpengfei@wxchina.com">ZhangPengFei</a>
 * @Discription
 * @Data 2017-3-24
 * @Version 1.0.0
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    /**
     * @param name
     * @return
     * @Cacheable 应用到读取数据的方法上，先从缓存中读取，如果没有再从DB获取数据，然后把数据添加到缓存中
     * unless 表示条件表达式成立的话不放入缓存
     */
    @Override
    @Cacheable(value = "user", key = "#root.targetClass + #name", unless = "#result eq null")
    public PersonEntity getPersonByName(String name) {
        PersonEntity person = personDao.findByName(name);
        return person;
    }

    /**
     * @param person
     * @return
     * @CachePut 应用到写数据的方法上，如新增/修改方法，调用方法时会自动把相应的数据放入缓存
     */
    @Override
    @CachePut(value = "user", key = "#root.targetClass + #result.name", unless = "#person eq null")
    public PersonEntity savePerson(PersonEntity person) {
        return personDao.save(person);
    }


}