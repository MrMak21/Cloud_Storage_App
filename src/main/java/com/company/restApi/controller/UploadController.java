package com.company.restApi.controller;

import com.company.restApi.domain.UplObject;
import com.company.restApi.domain.User;
import com.company.restApi.mappers.StatusToUploadModelMapper;
import com.company.restApi.model.UploadModel;
import com.company.restApi.service.UploadService;
import com.company.restApi.service.UserService;
import com.company.restApi.service.formatFileSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UploadController {

    @Autowired
    UserService userService;

    @Autowired
    formatFileSize formatFileSize;

    @Autowired
    StatusToUploadModelMapper statusToUploadModelMapper;

    @Autowired
    UploadService uploadService;

    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "/home/mak21/Desktop/Spring_Projects/Cloud_App/Upload/";

    @GetMapping("/upload")
    public String uploading() { return "upload";
    }

    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        //Get Users email
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in email

        try {

            //Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + name +"/" + file.getOriginalFilename());
            Files.write(path, bytes);

            File arxeio = new File(UPLOADED_FOLDER + name + "/" + file.getOriginalFilename());
            long size = arxeio.length();


            UploadModel uploadModel = statusToUploadModelMapper.mapToUploadModel(UPLOADED_FOLDER + name +"/" + file.getOriginalFilename()+"/",name,size);
            uploadService.create(uploadModel);



            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

    @GetMapping("/uploads")
    public String uploads(Model model){



        //Get Users email
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in email

        new File("/home/mak21/Desktop/Spring_Projects/Cloud_App/Upload/"+name).mkdirs();

        File file =  new File("/home/mak21/Desktop/Spring_Projects/Cloud_App/Upload/"+name+"/");

        List<File> fileslist = new ArrayList<>();
        List<UplObject> items = new ArrayList<>();


        long numberOfFiles =0;
        long sizeOfFolder = 0;



        // check if the specified pathname is directory first
        if(file.isDirectory()){
            //list all files on directory
            File[] files = file.listFiles();
            for(File s:files){

                fileslist.add(new File(s.getName()));
                items.add(new UplObject(s.getName(),formatFileSize.formatFileSizes(s.length()),0));
                numberOfFiles +=1;
                sizeOfFolder += s.length();

            }
        }


        model.addAttribute("test",items);



        User user = userService.findUserByEmail(name);
        String sizeOfFile = formatFileSize.formatFileSizes(sizeOfFolder);
        long totalSpaceLeft = 5368709120L - sizeOfFolder;
        String totalSpace = formatFileSize.formatFileSizes(totalSpaceLeft);

        model.addAttribute("firstname",user.getFirstname());
        model.addAttribute("fileNameList",fileslist);
        model.addAttribute("numbersOfFiles",numberOfFiles);
        model.addAttribute("sizeOfFile",sizeOfFile);
        model.addAttribute("space",totalSpace);



        return "uploadss";
    }
}
