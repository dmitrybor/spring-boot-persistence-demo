package com.pydog.psdemo.dao;

import com.pydog.psdemo.data.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class DeliveryDaoImpl implements DeliveryDao {
    private final EntityManager entityManager;

    @Autowired
    public DeliveryDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void persist(Delivery delivery) {
        entityManager.persist(delivery);
    }

    @Override
    public Delivery find(Long id) {
        return entityManager.find(Delivery.class, id);
    }

    @Override
    public Delivery merge(Delivery delivery) {
        return entityManager.merge(delivery);
    }

    @Override
    public void delete(Long id) {
        Delivery delivery = find(id);
        entityManager.remove(delivery);
    }
}
