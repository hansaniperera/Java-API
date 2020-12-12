package com.first.test.service.impl;

import com.first.test.Domain.User;
import com.first.test.persister.UserPersister;
import com.first.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserPersister userPersister;

    public User createUser(User user) {
        return userPersister.save(user);
    }

    public User getUser(long id) {
        return userPersister.findByUserIdHQL(id).get();
    }

    public User updateUser(String name, Long id) {
        Optional<User> user = userPersister.findById(id);
        if (user.isPresent()) {
            User newUser = user.get();
            newUser.setfName(name);
            return userPersister.save(newUser);
        } else {
            return null;
        }
    }
}
