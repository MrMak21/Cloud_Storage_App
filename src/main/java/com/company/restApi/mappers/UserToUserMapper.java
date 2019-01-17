package com.company.restApi.mappers;

import com.company.restApi.domain.User;
import com.company.restApi.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserToUserMapper {
    public UserModel mapToUserModel(User user){

        UserModel userModel = new UserModel();
        userModel.setFirstname(user.getFirstname());
        userModel.setLastname(user.getLastname());
        userModel.setPassword(user.getPassword());
        userModel.setEmail(user.getEmail());
        userModel.setType(user.getType());

        return userModel;
    }
}
