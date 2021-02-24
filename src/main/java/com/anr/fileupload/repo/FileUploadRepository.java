package com.anr.fileupload.repo;

import com.anr.fileupload.entity.FileMetaData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileUploadRepository extends CrudRepository<FileMetaData, Integer> {
}
