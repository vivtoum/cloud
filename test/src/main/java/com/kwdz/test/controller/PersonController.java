package com.kwdz.test.controller;

import com.kwdz.test.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 0.0.1
 * @author: huyt
 * @date: 2019/4/3 22:32
 */
@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/p/{name}")
    public void index(@PathVariable("name") String name) {
        personService.getPersonByName(name);
    }
}
