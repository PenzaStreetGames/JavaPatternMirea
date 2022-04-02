package com.hyberlet.study_1.service;

import com.hyberlet.study_1.model.User;

public interface UserService {
    User add(User user);
    Iterable<User> getAll();
    User getCurrentUser();
}
