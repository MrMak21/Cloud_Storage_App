package com.company.restApi.controller;

import com.company.restApi.form.SignUpForm;
import com.company.restApi.mappers.RegisterFormToModelMapper;
import com.company.restApi.model.UserModel;
import com.company.restApi.repository.UserJpaRepository;
import com.company.restApi.service.UserService;
import com.company.restApi.validators.RegisterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

import java.io.File;

import static com.company.restApi.utils.GlobalAttributes.ERROR_MESSAGE;

@Controller
public class AnonumousController {
    private static final String REGISTER_FORM = "signUpForm";

    @Autowired
    RegisterFormToModelMapper registerMapper;

    @Autowired
    private RegisterValidator registerValidator;

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Autowired
    private UserService userService;


    @InitBinder(REGISTER_FORM)
    protected void initBinder(final WebDataBinder binder) {binder.addValidators(registerValidator); }



    @GetMapping(value ="/")
    public String index(){
        return "redirect:/login";
    }

    @GetMapping(value = "/login")
    public String login(){
        return "login";
    }

    @GetMapping(value = "/signUp")
    public String signUp(Model model){
        model.addAttribute(REGISTER_FORM,new SignUpForm());
        return "signUp";
    }
    @PostMapping(value = "/signUp")
    public String signUp(Model model,
                           @Valid @ModelAttribute(REGISTER_FORM)
                                   SignUpForm signUpForm,
                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            //have some error handling here, perhaps add extra error messages to the model
            model.addAttribute(ERROR_MESSAGE, "an error occurred");
            return "create_user";
        }
        UserModel userModel = registerMapper.mapToUserModel(signUpForm);
        userService.create(userModel);

        return "redirect:/login";
    }
}
