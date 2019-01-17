package com.company.restApi.validators;


import com.company.restApi.form.SignUpForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class RegisterValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {

        return SignUpForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {

        SignUpForm signUpForm = (SignUpForm) target;

        //here perform your checks
        if (signUpForm.getEmail() == null) {
            // add an error for the field called ‘email’
            errors.rejectValue("email", "email is empty");}
//        }else if(registerForm.getAfm() == 0){
//            errors.rejectValue("afm","afm is empty");
//        }else if (registerForm.getPlate() == null){
//            errors.rejectValue("plate","plate is empty");
//        }else if (registerForm.getLastName() == null){
//            errors.rejectValue("lastName","Last name is empty");
//        }else if(registerForm.getPassword() == null){
//            errors.rejectValue("password","Password is empty");
//        }else if(registerForm.getType() == null){
//            errors.rejectValue("type","type is empty");
//        }

        ValidationUtils.rejectIfEmpty(errors, "email", "email.empty");
    }

}
