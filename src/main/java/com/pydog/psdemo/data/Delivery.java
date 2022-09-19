package com.pydog.psdemo.data;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@NamedQueries({
        @NamedQuery(
                name = "Delivery.findByRecipientName",
                query = "SELECT d FROM Delivery d WHERE d.recipient = :recipientName"
        ),
        @NamedQuery(
                name = "Delivery.getRecipientAndPrice",
                query = "SELECT new com.pydog.psdemo.data.RecipientAndPrice(p.delivery.recipient, sum(p.price)) " +
                        "FROM Plant p " +
                        "WHERE p.delivery.id = :deliveryId " +
                        "GROUP BY p.delivery.id"
        )
})
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

    @OneToMany(mappedBy = "delivery", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Plant> plants;

    @Type(type = "yes_no")
    private Boolean completed = false;

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

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
