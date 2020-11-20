
package com.ITHS.Webshop.controllers;

import com.ITHS.Webshop.models.User;
import com.ITHS.Webshop.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> list() {
        return userRepository.findAll();
    }

    @GetMapping
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public User get(@PathVariable int id) {
        return userRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody final User user) {

        return userRepository.saveAndFlush(user);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public User update(@PathVariable int id, @RequestBody User user) {
        //TODO: Add validation that all attributes are passed in, otherwise return a 400 bad payload
        User existingUser = userRepository.getOne(id);
        BeanUtils.copyProperties(user, existingUser, "id");
        return userRepository.saveAndFlush(existingUser);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User login (@RequestBody User user) throws Exception{
    User loginUser = userRepository.findByUsernameIgnoreCase(user.getUsername());
    if (loginUser.getPassword().equals(user.getPassword())){
        return loginUser;
    }
        throw new Exception("Login Failed: Please enter valid username and password");
    }

}

