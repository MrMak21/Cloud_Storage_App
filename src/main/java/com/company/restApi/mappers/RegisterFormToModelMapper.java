package com.company.restApi.mappers;

import com.company.restApi.form.SignUpForm;
import com.company.restApi.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class RegisterFormToModelMapper {

    public UserModel mapToUserModel(SignUpForm signUpForm){

        UserModel userModel = new UserModel();
        userModel.setFirstname(signUpForm.getFirstname());
        userModel.setLastname(signUpForm.getLastname());
        userModel.setEmail(signUpForm.getEmail());
        userModel.setPassword(signUpForm.getPassword());
        userModel.setType(signUpForm.getType());

        return userModel;

    }
}
