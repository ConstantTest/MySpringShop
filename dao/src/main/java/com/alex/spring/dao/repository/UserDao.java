package com.alex.spring.dao.repository;

import com.alex.spring.dao.model.User;

import java.util.List;

/**
 * Created by Alex on 24.04.2018.
 */
public interface UserDao {
    void register(User user);
    List<User> findAll();
}
