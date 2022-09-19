package com.pydog.psdemo.dao;

import com.pydog.psdemo.data.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {

    Plant findByName(String name);

    @Query("SELECT " +
            "CASE " +
            "WHEN (p.delivery IS NOT NULL) THEN p.delivery.completed " +
            "ELSE false " +
            "END " +
            "FROM Plant p " +
            "WHERE p.id = :plantId")
    Boolean plantIsDelivered(@Param("plantId") Long plantId);
}
