package com.alex.spring.services;

import com.alex.spring.services.dto.UserDto;

import java.util.List;

/**
 * Created by Alex on 24.04.2018.
 */
public interface UserService {
    void register(UserDto userDto);
    List<UserDto> findAll();
}
