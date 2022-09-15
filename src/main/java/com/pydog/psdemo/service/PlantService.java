package com.pydog.psdemo.service;

import com.pydog.psdemo.data.Plant;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PlantService {
    public Plant getPlantByName(final String plantName) {
        Plant plant = new Plant();
        plant.setName(plantName);
        plant.setPrice(new BigDecimal("1.23"));
        return plant;
    }
}
