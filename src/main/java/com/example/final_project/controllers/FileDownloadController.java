package com.example.final_project.controllers;

import com.example.final_project.models.AdvertiseEntity;
import com.example.final_project.models.ImageEntity;
import com.example.final_project.services.AdvertiseService;
import com.example.final_project.services.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping(path = "/downloadFile", produces = "application/undefined")
public class FileDownloadController {

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private AdvertiseService advertiseService;

    public FileDownloadController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable ("fileName") String fileName) throws FileNotFoundException {
      //  AdvertiseEntity advertiseEntity = fileStorageService.getFile(fileName);

        ImageEntity imageEntity = fileStorageService.getFile(fileName);

        return ResponseEntity.ok()
               .contentType(MediaType.IMAGE_PNG)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + imageEntity.getFileName() + "\"")
               .body(new ByteArrayResource(imageEntity.getImage()));

    }


}
