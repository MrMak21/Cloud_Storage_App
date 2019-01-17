package com.company.restApi.repository;

import com.company.restApi.domain.Upload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UploadJpaRepository extends JpaRepository<Upload,Long> {

    Upload save(Upload upload);






}
