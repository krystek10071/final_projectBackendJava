package com.example.final_project.services;

import com.example.final_project.exeptions.FileStorageException;
import com.example.final_project.models.ImageEntity;
import com.example.final_project.repository.AdertiseRepository;
import com.example.final_project.models.AdvertiseEntity;
import com.example.final_project.repository.ImageEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

@Service
public class FileStorageService {

    private final ImageEntityRepository imageRepository;

    public FileStorageService(ImageEntityRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public ImageEntity store(MultipartFile file, long idAdverise) throws IOException{

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        String fileDownloadUri = "" ;

        // Check if the file's name contains invalid characters
        if (fileName.contains("..")) {
            throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
        }

        //create new image object
        ImageEntity image = new ImageEntity(fileName, file.getSize(), fileDownloadUri, file.getContentType(),file.getBytes(), idAdverise);

        //todo
        //save to database
        return imageRepository.save(image);
    }


    public ImageEntity getFile(String fileId) throws FileNotFoundException {
        return  imageRepository.findById(Long.valueOf(fileId))
              .orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));
    }

}
