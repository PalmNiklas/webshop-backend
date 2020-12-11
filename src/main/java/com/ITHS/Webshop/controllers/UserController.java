
package com.ITHS.Webshop.controllers;

import com.ITHS.Webshop.models.Order;
import com.ITHS.Webshop.models.User;
import com.ITHS.Webshop.repositories.UserRepository;
import com.ITHS.Webshop.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> list() {
        return userService.getAllUsers();
    }

    @GetMapping
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public User get(@PathVariable int id) {
        return userService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody final User user) {

        return userService.create(user);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public User update(@PathVariable int id, @RequestBody User user) {
      return userService.update(id, user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User login (@RequestBody User user) {
      return   userService.login(user);
    }




}

