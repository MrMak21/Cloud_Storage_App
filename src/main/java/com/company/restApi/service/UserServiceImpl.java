package com.company.restApi.service;

import com.company.restApi.domain.User;
import com.company.restApi.mappers.UserToUserMapper;
import com.company.restApi.model.UserModel;
import com.company.restApi.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserJpaRepository userJpaRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserToUserMapper userToUserMapper;



    @Override
    public User findUserByLastname(String lastname) {
        return userJpaRepository.findUserByLastname(lastname);
    }

    @Override
    public User findUserByEmail(String email) {
        return userJpaRepository.findUserByEmail(email);
    }


    @Override
    public List<User> findall() {
        return userJpaRepository.findAll();
    }

    @Override
    public UserModel create(UserModel userModel) {
        User user = new User(userModel.getFirstname(),
                userModel.getLastname(),
                userModel.getEmail(),
                passwordEncoder.encode(userModel.getPassword()),
                userModel.getType());

        User savedUser = userJpaRepository.save(user);
        return userToUserMapper.mapToUserModel(savedUser);
    }
}
