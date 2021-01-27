package com.example.final_project.repository;

import com.example.final_project.models.AdvertiseEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdertiseRepository extends JpaRepository<AdvertiseEntity, Long> {

   // Select a From AdvertiseEntity a" + " left join fetch a.images
    //   @Query(value = "SELECT Advertise.title, Image.id FROM Advertise LEFT JOIN Image ON Advertise.id = Image.advertise_id",
    //   nativeQuery = true)


    List<AdvertiseEntity> findAllByTitle(String title);

     @Query("Select a From AdvertiseEntity a" + " left join fetch a.images")
    List<AdvertiseEntity> findAllAdvertise(PageRequest page);


    @Query(value = "SELECT Advertise.title, Image.id FROM Advertise LEFT JOIN Image ON Advertise.id = Image.advertise_id",
    nativeQuery = true)
    List<?> findAdvertise();




}
