package com.ITHS.Webshop.services;

import com.ITHS.Webshop.models.Order;
import com.ITHS.Webshop.models.OrderStatus;
import com.ITHS.Webshop.models.User;
import com.ITHS.Webshop.repositories.OrderStatusRepository;
import com.ITHS.Webshop.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderStatusRepository statusRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getById(int id) {
        return userRepository.getOne(id);
    }

    @Override
    public User getByName(String name) {
        return null;
    }


    @Override
    public User create(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User update(int id, User user) {
        //TODO: Add validation that all attributes are passed in, otherwise return a 400 bad payload
        User existingUser = userRepository.getOne(id);
        BeanUtils.copyProperties(user, existingUser, "id");
        return userRepository.saveAndFlush(existingUser);
    }

    @Override
    public User login(User user)  {
        User loginUser = userRepository.findByUsernameIgnoreCase(user.getUsername());
        if (loginUser.getPassword().equals(user.getPassword())){
            return loginUser;
        }
        return null;
    }

}
