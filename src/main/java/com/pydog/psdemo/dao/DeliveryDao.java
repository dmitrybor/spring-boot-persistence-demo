package com.pydog.psdemo.dao;

import com.pydog.psdemo.data.Delivery;

public interface DeliveryDao {
    void persist(Delivery delivery);

    Delivery find(Long id);

    Delivery merge(Delivery delivery);

    void delete(Long id);
}
