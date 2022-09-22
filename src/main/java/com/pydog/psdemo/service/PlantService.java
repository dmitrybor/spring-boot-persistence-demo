package com.pydog.psdemo.service;

import com.pydog.psdemo.dao.PlantRepository;
import com.pydog.psdemo.data.Plant;
import com.pydog.psdemo.error.NotFoundException;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PlantService {

    private final PlantRepository plantRepository;

    @Autowired
    public PlantService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    public Plant getPlantByName(final String plantName) {
        return plantRepository.findByName(plantName);
    }

    public Boolean isPlantDelivered(Long plantId) {
        Plant plant = plantRepository.findById(plantId).orElseThrow(() -> new NotFoundException("Plant not found"));
        return plant.getDelivery() != null && BooleanUtils.isTrue(plant.getDelivery().getCompleted());
    }

    public List<Plant> findCheaperThan(BigDecimal price) {
        return plantRepository.findCheaperThan(price);
    }

    public Long save(@NonNull Plant plant) {
        Plant savedPlant = plantRepository.save(plant);
        return savedPlant.getId();
    }
}
