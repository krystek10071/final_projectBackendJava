package com.example.final_project.controllers;


import com.example.final_project.models.AdvertiseEntity;
import com.example.final_project.models.ImageEntity;
import com.example.final_project.models.Response;
import com.example.final_project.services.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FileUploadController {

    FileStorageService fileStorageService;

    public FileUploadController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping("/uploadFile/{id_advertise}")
    public Response uploadFile(@RequestParam("file") MultipartFile file, @PathVariable ("id_advertise") String id) throws IOException {

        long idAdvertise = Long.parseLong(id);
        ImageEntity image = fileStorageService.store(file, idAdvertise);


        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile")
                .path(id)
                .toUriString();

            return new Response(image.getFileName(), fileDownloadUri, file.getContentType(), file.getSize());
    }


    @PostMapping("/uploadMultipleFiles/{id_advertise}")
    public List<Response> uploadMultipleFile(@RequestParam("files") MultipartFile[] files, @PathVariable("id_advertise")  String id_advertise){

        return Arrays.stream(files)
                .map(file -> {
                    try {
                        return uploadFile(file, id_advertise);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .collect(Collectors.toList());
    }

}
