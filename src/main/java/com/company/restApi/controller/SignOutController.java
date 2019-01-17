package com.company.restApi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignOutController {

    @GetMapping(value = "/logoutpage")
    public String logout(){
        return "login";
    }
}
