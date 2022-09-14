package com.pydog.psdemo.data;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "address_full", length = 500)
    @Type(type = "nstring")
    private String address;

    @Nationalized
    private String recipient;
    private LocalDate deliveryDate;
    private LocalTime deliveryTime;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "delivery")
    private List<Plant> plants;

    @Type(type = "yes_no")
    private Boolean completed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public LocalTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
