package com.anr.fileupload.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface FileUploadService {

    String uploadFile( String jsonPayload, Map<String, MultipartFile> fileMap ) throws IOException;
}
