package com.shoppingcart;

import java.math.BigDecimal;


public class Item {
    private final ItemType itemType;
    private final String id;
    private final String name;
    private final BigDecimal price;

    public Item(String id, String name, ItemType itemType, BigDecimal price) {
        this.id=id;
        this.name=name;
        this.itemType=itemType;
        this.price=price;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
