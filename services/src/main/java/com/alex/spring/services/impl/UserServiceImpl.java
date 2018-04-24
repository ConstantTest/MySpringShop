package com.alex.spring.services.impl;

import com.alex.spring.dao.model.User;
import com.alex.spring.dao.repository.UserDao;
import com.alex.spring.services.UserService;
import com.alex.spring.services.converters.UserConverter;
import com.alex.spring.services.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 24.04.2018.
 */
@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private UserConverter converter;

    @Autowired
    public UserServiceImpl(UserDao userDao, UserConverter converter) {
        this.userDao = userDao;
        this.converter = converter;
    }

    @Override
    public void register(UserDto userDto) {
       User user = converter.toEntity(userDto);
       userDao.register(user);
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = userDao.findAll();
        List<UserDto> userDtos = new ArrayList<UserDto>();
        for (User u: users) {
            userDtos.add(converter.toDto(u));
        }
        return userDtos;
    }
}
