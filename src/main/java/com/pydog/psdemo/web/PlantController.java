package com.pydog.psdemo.web;

import com.fasterxml.jackson.annotation.JsonView;
import com.pydog.psdemo.data.Plant;
import com.pydog.psdemo.service.PlantService;
import com.pydog.psdemo.web.dto.PlantResponse;
import com.pydog.psdemo.web.dto.View;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/plant")
public class PlantController {

    private final PlantService plantService;

    @Autowired
    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping("/dto")
    public PlantResponse getPlantDto(@RequestParam("name") @NotNull String name) {
        Plant plant = plantService.getPlantByName(name);
        return convertToPlantResponse(plant);
    }

    @GetMapping("/view")
    @JsonView(View.PlantView.class)
    public Plant getPlantView(@RequestParam("name") @NotNull String name) {
        return plantService.getPlantByName(name);
    }

    private PlantResponse convertToPlantResponse(final Plant plant) {
        PlantResponse plantResponse = new PlantResponse();
        BeanUtils.copyProperties(plant, plantResponse);
        return plantResponse;
    }
}
