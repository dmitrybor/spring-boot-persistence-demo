package com.pydog.psdemo.web.dto;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class PlantDto {
    @NotNull
    private String name;
    @NotNull
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
