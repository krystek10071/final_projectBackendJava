package com.example.final_project.repository;

import com.example.final_project.models.ImageEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ImageEntityRepository extends JpaRepository<ImageEntity, Long> {

    List<ImageEntity> findAllByAdvertiseIdIn(List<Long> ids);
}
