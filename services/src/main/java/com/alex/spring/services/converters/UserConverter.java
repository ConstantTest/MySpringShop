package com.alex.spring.services.converters;

import com.alex.spring.dao.model.User;
import com.alex.spring.services.dto.UserDto;

/**
 * Created by Alex on 24.04.2018.
 */
public interface UserConverter {
    User toEntity(UserDto userDto);
    UserDto toDto(User user);
}
