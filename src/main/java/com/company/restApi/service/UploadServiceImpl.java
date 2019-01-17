package com.company.restApi.service;

import com.company.restApi.domain.Upload;
import com.company.restApi.mappers.UploadToUploadMapper;
import com.company.restApi.model.UploadModel;
import com.company.restApi.repository.UploadJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    UploadJpaRepository uploadJpaRepository;

    @Autowired
    UploadToUploadMapper uploadToUploadMapper;

    @Override
    public UploadModel create(UploadModel uploadModel) {
        Upload upload = new Upload(
                uploadModel.getRef_key(),
                uploadModel.getUser(),
                uploadModel.getSize());

        Upload savedUpload =  uploadJpaRepository.save(upload);
        return uploadToUploadMapper.mapToUploadModel(savedUpload);
    }

    @Override
    public void delete(long id) { uploadJpaRepository.deleteById(id);
        }
}
