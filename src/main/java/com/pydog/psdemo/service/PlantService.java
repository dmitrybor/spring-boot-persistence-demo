package com.pydog.psdemo.service;

import com.pydog.psdemo.dao.PlantRepository;
import com.pydog.psdemo.data.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return plantRepository.plantIsDelivered(plantId);
    }
}
