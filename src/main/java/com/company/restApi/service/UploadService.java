package com.company.restApi.service;

import com.company.restApi.domain.Upload;
import com.company.restApi.model.UploadModel;

public interface UploadService {

    UploadModel create(UploadModel uploadModel);
    void delete(long id);


}
