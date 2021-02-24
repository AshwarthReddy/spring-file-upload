package com.anr.fileupload;

import com.anr.fileupload.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;





    @PostMapping()
    public String createDocument( @RequestParam String jsonPayload, HttpServletRequest request ) throws IOException {

        Map<String, MultipartFile> fileMap = new HashMap<String, MultipartFile>();
        if ( request instanceof MultipartHttpServletRequest ) {
            MultipartHttpServletRequest multiRequest = ( MultipartHttpServletRequest ) request;
            fileMap = multiRequest.getFileMap();
        }
        return fileUploadService.uploadFile(jsonPayload, fileMap);
    }
}
