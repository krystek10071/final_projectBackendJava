package com.example.final_project.controllers;

import com.example.final_project.dto.AdvertiseDto;
import com.example.final_project.models.AdvertiseEntity;

import java.util.List;
import java.util.stream.Collectors;

public class AdvertiseDtoMapper {

    public static List<AdvertiseDto> mapToAdvertiseDtos(List<AdvertiseEntity> advertises) {
        return advertises.stream()
                .map(advertise -> mapToAdvertiseDto(advertise))
                .collect(Collectors.toList());
    }

    private static AdvertiseDto mapToAdvertiseDto(AdvertiseEntity advertise) {
        return AdvertiseDto.builder()
                .id(advertise.getId())
                .title(advertise.getTitle())
                .price(advertise.getPrice())
                .location(advertise.getLocation())
                .province(advertise.getProvince())
                .contactNumber(advertise.getContactNumber())
                .description(advertise.getDescription())
                .category(advertise.getCategory())
                .timeAdd(advertise.getTimeAdd())
                .build();
    }
}
