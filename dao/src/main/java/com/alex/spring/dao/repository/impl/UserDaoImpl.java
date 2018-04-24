package com.alex.spring.dao.repository.impl;

import com.alex.spring.dao.model.User;
import com.alex.spring.dao.repository.UserDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alex on 24.04.2018.
 */
@Repository
public class UserDaoImpl implements UserDao {
    private Map<Long, User> users = new HashMap<Long,User>();
    private static volatile Long idGenerator = 1L;

    @Override
    public void register(User user) {
        user.setId(idGenerator++);
        users.put(user.getId(), user);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<User>(users.values());
    }
}
