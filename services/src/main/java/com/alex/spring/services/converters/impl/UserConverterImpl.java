package com.alex.spring.services.converters.impl;

import com.alex.spring.dao.model.User;
import com.alex.spring.services.converters.UserConverter;
import com.alex.spring.services.dto.UserDto;
import org.springframework.stereotype.Component;

/**
 * Created by Alex on 24.04.2018.
 */
@Component
public class UserConverterImpl implements UserConverter{

    @Override
    public User toEntity(UserDto userDto) {
        return new User(
                null,
                userDto.getFirstName(),
                userDto.getLastName(),
                Integer.parseInt(userDto.getAge())
        );
    }

    @Override
    public UserDto toDto(User entity) {
        return new UserDto(
                entity.getFirstName(),
                entity.getLastName(),
                String.valueOf(entity.getAge())
        );
    }
}
