package com.pydog.psdemo.data;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "flower")
public class Flower extends Plant {

    private String color;


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
