package com.pydog.psdemo.dao;

import com.pydog.psdemo.data.Delivery;

import java.util.List;

public interface DeliveryDao {
    void persist(Delivery delivery);

    Delivery find(Long id);

    List<Delivery> findByRecipient(String name);

    Delivery merge(Delivery delivery);

    void delete(Long id);
}
