package com.pydog.psdemo.data;

import java.math.BigDecimal;

public class RecipientAndPrice {
    final String recipient;
    final BigDecimal price;

    public RecipientAndPrice(String recipient, BigDecimal price) {
        this.recipient = recipient;
        this.price = price;
    }

    public String getRecipient() {
        return recipient;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
