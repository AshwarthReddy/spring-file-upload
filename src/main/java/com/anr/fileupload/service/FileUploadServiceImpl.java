package com.anr.fileupload.service;

import com.anr.fileupload.entity.FileMetaData;
import com.anr.fileupload.repo.FileUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    public static final String FILE_UPLOADED_SUCCESSFULLY = "file uploaded successfully";
    @Autowired
    private FileUploadRepository fileUploadRepository;


    public static final String ADDHAR_FILE_NAME = "AADHAAR";
    public static final String PAN_CARD_FILE_NAME = "PAN_CARD";


    @Override
    public String uploadFile( String jsonPayload, Map<String, MultipartFile> fileMap ) throws IOException {

        List<FileMetaData> fileMetaData = new ArrayList<>();
        if (fileMap.containsKey(ADDHAR_FILE_NAME)) {
            fileMetaData.add(new FileMetaData(ThreadLocalRandom.current().nextInt(), ADDHAR_FILE_NAME, fileMap.get(ADDHAR_FILE_NAME).getBytes()));
        }
        if (fileMap.containsKey(PAN_CARD_FILE_NAME)) {
            fileMetaData.add(new FileMetaData(ThreadLocalRandom.current().nextInt(), PAN_CARD_FILE_NAME, fileMap.get(PAN_CARD_FILE_NAME).getBytes()));
        }
        fileUploadRepository.saveAll(fileMetaData);

        return FILE_UPLOADED_SUCCESSFULLY;
    }

}
