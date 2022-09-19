package com.pydog.psdemo.dao;

import com.pydog.psdemo.data.Delivery;
import com.pydog.psdemo.data.RecipientAndPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
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
    public List<Delivery> findByRecipient(String name) {
        TypedQuery<Delivery> query = entityManager.createNamedQuery("Delivery.findByRecipientName", Delivery.class);
        query.setParameter("recipientName", name);
        return query.getResultList();
    }

    @Override
    public RecipientAndPrice getRecipientAndPriceForDelivery(Long deliveryId) {
        TypedQuery<RecipientAndPrice> query = entityManager.createNamedQuery("Delivery.getRecipientAndPrice", RecipientAndPrice.class);
        query.setParameter("deliveryId", deliveryId);
        return query.getSingleResult();
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
