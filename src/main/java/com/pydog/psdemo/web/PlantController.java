package com.pydog.psdemo.web;

import com.fasterxml.jackson.annotation.JsonView;
import com.pydog.psdemo.data.Plant;
import com.pydog.psdemo.service.PlantService;
import com.pydog.psdemo.web.dto.PlantDto;
import com.pydog.psdemo.web.dto.View;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/plant")
public class PlantController {

    private final PlantService plantService;

    @Autowired
    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping("/dto")
    public PlantDto getPlantDto(@RequestParam("name") @NotNull String name) {
        Plant plant = plantService.getPlantByName(name);
        return convertToPlantResponse(plant);
    }

    @GetMapping("/view")
    @JsonView(View.PlantView.class)
    public Plant getPlantView(@RequestParam("name") @NotNull String name) {
        return plantService.getPlantByName(name);
    }

    @GetMapping("/delivered")
    public Boolean isPlantDelivered(@RequestParam("plantId") Long plantId, final HttpServletResponse response) {
        response.addHeader(HttpHeaders.CACHE_CONTROL, "no-store");
        return plantService.isPlantDelivered(plantId);
    }

    @GetMapping
    public List<PlantDto> getPlants(@RequestParam(value = "maxPrice", defaultValue = "0") BigDecimal maxPrice) {
        List<Plant> plants = plantService.findCheaperThan(maxPrice);
        return plants.stream().map(this::convertToPlantResponse).collect(Collectors.toList());
    }

    @PostMapping
    public Long addPlant(@Valid @RequestBody PlantDto plantDto) {
        Plant plant = convertToPlantEntity(plantDto);
        return plantService.save(plant);
    }

    private PlantDto convertToPlantResponse(@NonNull final Plant plant) {
        PlantDto plantDto = new PlantDto();
        BeanUtils.copyProperties(plant, plantDto);
        return plantDto;
    }

    private Plant convertToPlantEntity(@NonNull final PlantDto plantDto) {
        Plant plant = new Plant();
        BeanUtils.copyProperties(plantDto, plant);
        return plant;
    }
}
