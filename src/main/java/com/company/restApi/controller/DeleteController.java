package com.company.restApi.controller;

import com.company.restApi.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;


@Controller
public class DeleteController {

    @Autowired
    UploadService uploadService;



    private static final String DIRECTORY = "/home/panos/IdeaProjects/makcloudapp/Upload/";


    @RequestMapping("/delete/{filename}")
    public String deleteFile(Model model, @PathVariable("filename") String filename) {

        //Get Users email
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in email


        File file = new File(DIRECTORY + name + "/" + filename);
        if (file.exists()) {
            file.delete();
        }

        return "redirect:/uploads";
    }
}

