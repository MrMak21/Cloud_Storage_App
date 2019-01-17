package com.company.restApi.mappers;

import com.company.restApi.model.UploadModel;
import com.company.restApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatusToUploadModelMapper {

    @Autowired
    UserService userService;

    public UploadModel mapToUploadModel(String ref,String email,long size){

        UploadModel uploadModel = new UploadModel();
        uploadModel.setRef_key(ref);
        uploadModel.setSize(size);
        uploadModel.setUser(userService.findUserByEmail(email));

        return uploadModel;
    }
}
