package com.gox.shop.jshop.service;

import com.gox.shop.jshop.entity.Role;
import com.gox.shop.jshop.entity.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    void saveRole(Role role);

    User getUser(String username);

    List<User> getAllUsers();
}
