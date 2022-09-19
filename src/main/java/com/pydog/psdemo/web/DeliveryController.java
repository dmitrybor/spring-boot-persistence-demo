package com.pydog.psdemo.web;

import com.pydog.psdemo.data.Delivery;
import com.pydog.psdemo.data.Plant;
import com.pydog.psdemo.data.RecipientAndPrice;
import com.pydog.psdemo.service.DeliveryService;
import com.pydog.psdemo.web.dto.DeliveryDto;
import com.pydog.psdemo.web.dto.PlantDto;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping
    public Long scheduleDelivery(@RequestBody DeliveryDto delivery) {
        return deliveryService.save(convert(delivery));
    }

    @GetMapping
    public List<DeliveryDto> findByRecipientName(@RequestParam("recipient") final String recipient) {
        List<Delivery> deliveries = deliveryService.findByRecipientName(recipient);
        return deliveries.stream().map(this::convert).collect(Collectors.toList());
    }

    @GetMapping("/recipientAndPrice")
    public RecipientAndPrice getRecipientAndPriceForDelivery(@RequestParam("deliveryId") Long deliveryId) {
        return deliveryService.getRecipientAndPriceForDelivery(deliveryId);
    }

    private Delivery convert(DeliveryDto deliveryDto) {
        Delivery delivery = new Delivery();
        delivery.setRecipient(deliveryDto.getName());
        delivery.setAddress(deliveryDto.getAddress());
        delivery.setDeliveryDate(deliveryDto.getDeliveryTime().toLocalDate());
        delivery.setDeliveryTime(deliveryDto.getDeliveryTime().toLocalTime());
        if (deliveryDto.getPlants() != null) {
            delivery.setPlants(deliveryDto.getPlants().stream().map(this::convert).collect(Collectors.toList()));
        }
        return delivery;
    }

    private Plant convert(PlantDto plantDto) {
        Plant plant = new Plant();
        BeanUtils.copyProperties(plantDto, plant);
        return plant;
    }

    private DeliveryDto convert(Delivery delivery) {
        DeliveryDto deliveryDto = new DeliveryDto();
        deliveryDto.setName(delivery.getRecipient());
        deliveryDto.setDeliveryTime(LocalDateTime.of(delivery.getDeliveryDate(), delivery.getDeliveryTime()));
        deliveryDto.setAddress(delivery.getAddress());
        if(delivery.getPlants() != null) {
            deliveryDto.setPlants(delivery.getPlants().stream().map(this::convert).collect(Collectors.toList()));
        }
        return deliveryDto;
    }

    private PlantDto convert(Plant plant) {
        PlantDto plantDto = new PlantDto();
        BeanUtils.copyProperties(plant, plantDto);
        return plantDto;
    }
}
