package com.pydog.psdemo.dao;

import com.pydog.psdemo.data.Delivery;
import com.pydog.psdemo.data.RecipientAndPrice;

import java.util.List;

public interface DeliveryDao {
    void persist(Delivery delivery);

    Delivery find(Long id);

    List<Delivery> findByRecipient(String name);

    RecipientAndPrice getRecipientAndPriceForDelivery(Long deliveryId);

    Delivery merge(Delivery delivery);

    void delete(Long id);
}
