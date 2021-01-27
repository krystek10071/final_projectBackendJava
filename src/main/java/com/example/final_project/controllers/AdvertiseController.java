package com.example.final_project.controllers;


import com.example.final_project.dto.AdvertiseDto;
import com.example.final_project.models.Advertise;
import com.example.final_project.models.AdvertiseEntity;
import com.example.final_project.models.ResponseAdvertise;
import com.example.final_project.services.AdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AdvertiseController {

    @Autowired
    AdvertiseService advertiseService;

    public AdvertiseController(AdvertiseService advertiseService) {
        this.advertiseService = advertiseService;
    }

    public AdvertiseController(){

    }

   @GetMapping("test")
   public List<?> getTestAdvertise(){
        return advertiseService.getTestAdvertises();
   }

    @GetMapping("/posts")
   public List<AdvertiseDto> getAdvertises(@RequestParam (required = false) int page){
        //return advertiseService.getAdvertises();

        return AdvertiseDtoMapper.mapToAdvertiseDtos(advertiseService.getAdvertises(page));
    }


    @GetMapping("/posts/{id}")
    public AdvertiseEntity getSingleAdvertise(@PathVariable long id){
        return  advertiseService.getSingleAdvertise(id);
    }

    @GetMapping("/posts/images")
    public List<AdvertiseEntity> getAdvertiseWithImage(@RequestParam (required = false) int page){
        return advertiseService.getAdvertisesWitchImage(page);
    }


    @PostMapping(value = "/new-advertise", consumes = "application/json", produces = "application/json")
    public ResponseAdvertise addAdvertise(@RequestBody Advertise advertise){
        AdvertiseEntity advertiseEntity = advertiseService.addAdvertise(advertise);

        return new ResponseAdvertise(advertiseEntity.getId(), advertiseEntity.getTitle(), advertiseEntity.getPrice(),
                advertiseEntity.getLocation(), advertiseEntity.getCategory(), advertiseEntity.getTimeAdd());
    }
    }
