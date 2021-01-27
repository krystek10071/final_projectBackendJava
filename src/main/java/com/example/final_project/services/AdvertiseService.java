package com.example.final_project.services;

import com.example.final_project.models.*;
import com.example.final_project.repository.AdertiseRepository;
import com.example.final_project.repository.ImageEntityRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class AdvertiseService {

    private static final int page_SIZE = 20;
    private AdertiseRepository adertiseRepository;
    private ImageEntityRepository imageEntityRepository;

    public AdvertiseService(AdertiseRepository adertiseRepository, ImageEntityRepository imageEntityRepository) {
        this.adertiseRepository = adertiseRepository;
        this.imageEntityRepository = imageEntityRepository;
    }

    public List<AdvertiseEntity> getAdvertises(int page){
        return adertiseRepository.findAllAdvertise(PageRequest.of(page, page_SIZE));
    }

    public List<?> getTestAdvertises(){
        return adertiseRepository.findAdvertise();
    }


    public AdvertiseEntity getSingleAdvertise(Long id){
        return adertiseRepository.findById(id).orElseThrow();
    }

    public AdvertiseEntity addAdvertise(Advertise advertise){

        AdvertiseEntity advertiseEntity = new AdvertiseEntity(advertise.getTitle(), advertise.getPrice(),advertise.getLocation(), advertise.getProvince(),
                advertise.getContactNumber(), advertise.getDescription(), advertise.getCategory(), new Date());

        return adertiseRepository.save(advertiseEntity);
    }

    public List<AdvertiseEntity> getAdvertisesWitchImage(int page) {
        List<AdvertiseEntity> allAdvertise =  adertiseRepository.findAllAdvertise(PageRequest.of(page, page_SIZE));
        List<Long> ids = allAdvertise.stream()
                .map(AdvertiseEntity::getId)
                .collect(Collectors.toList());
        List<ImageEntity> imageEntities = imageEntityRepository.findAllByAdvertiseIdIn(ids);

        allAdvertise.forEach(advertise -> advertise.setImages(extractImages(imageEntities, advertise.getId())));

        return allAdvertise;
    }

    private List<ImageEntity> extractImages(List<ImageEntity> imageEntities, long id) {
        return imageEntities.stream()
                .filter(image -> image.getAdvertiseId() == id)
                .collect(Collectors.toList());
    }
}
