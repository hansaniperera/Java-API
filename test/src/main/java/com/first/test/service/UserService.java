package com.first.test.service;

import com.first.test.Domain.User;

public interface UserService {

    User createUser(User user);

    User getUser(long id);

    User updateUser(String name, Long id);
}
