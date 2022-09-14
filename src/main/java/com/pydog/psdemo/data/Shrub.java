package com.pydog.psdemo.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "shrub")
public class Shrub extends Plant {

    @Column(name = "hight")
    private Long height;

    @Column(name = "width")
    private Long width;

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }
}
