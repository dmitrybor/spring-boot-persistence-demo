package com.pydog.psdemo.service;

import com.pydog.psdemo.dao.DeliveryDao;
import com.pydog.psdemo.data.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {

    private final DeliveryDao deliveryDao;

    @Autowired
    public DeliveryService(DeliveryDao deliveryDao) {
        this.deliveryDao = deliveryDao;
    }

    public Long save(Delivery delivery) {
        delivery.getPlants().forEach(plant -> plant.setDelivery(delivery));
        deliveryDao.persist(delivery);
        return delivery.getId();
    }

    public List<Delivery> findByRecipientName(final String recipientName) {
        return deliveryDao.findByRecipient(recipientName);
    }
}
