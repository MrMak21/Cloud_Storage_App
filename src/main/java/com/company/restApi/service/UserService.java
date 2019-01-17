package com.company.restApi.service;

import com.company.restApi.domain.User;
import com.company.restApi.model.UserModel;

import java.util.List;

public interface UserService {

    User findUserByLastname(String lastname);
    User findUserByEmail(String email);
    List<User> findall();
    UserModel create(UserModel user);
}
