package com.ITHS.Webshop.services;

import com.ITHS.Webshop.models.Order;
import com.ITHS.Webshop.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> getAllUsers();
    public  User getById(int id);
    public User getByName(String name);
    public  User create(User user);
    public  User update(int id, User user);

    public User login(User user);


}
