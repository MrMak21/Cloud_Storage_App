package com.company.restApi.mappers;

import com.company.restApi.domain.Upload;
import com.company.restApi.model.UploadModel;
import org.springframework.stereotype.Component;

@Component
public class UploadToUploadMapper {
    public UploadModel mapToUploadModel(Upload upload){

        UploadModel uploadModel = new UploadModel();

        uploadModel.setRef_key(upload.getRef_key());
        uploadModel.setUser(upload.getUser());
        uploadModel.setSize(upload.getSize());

        return uploadModel;
    }


}
