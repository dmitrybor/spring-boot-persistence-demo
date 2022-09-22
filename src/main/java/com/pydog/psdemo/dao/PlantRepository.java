package com.pydog.psdemo.dao;

import com.pydog.psdemo.data.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {

    Plant findByName(String name);

    @Query("SELECT p.delivery.completed " +
            "FROM Plant p " +
            "WHERE p.id = :plantId")
    Boolean plantIsDelivered(@Param("plantId") Long plantId);

    @Query("SELECT p FROM Plant p WHERE p.price < :price")
    List<Plant> findCheaperThan(@Param("price") BigDecimal price);
}
