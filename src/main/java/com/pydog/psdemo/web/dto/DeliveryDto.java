package com.pydog.psdemo.web.dto;

import java.time.LocalDateTime;
import java.util.List;

public class DeliveryDto {
    private String name;
    private String address;
    private LocalDateTime deliveryTime;
    private List<PlantDto> plants;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public List<PlantDto> getPlants() {
        return plants;
    }

    public void setPlants(List<PlantDto> plants) {
        this.plants = plants;
    }
}
