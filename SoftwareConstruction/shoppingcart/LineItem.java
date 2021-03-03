package com.shoppingcart;

import java.math.BigDecimal;
import java.util.Objects;

public class LineItem {
    private String itemId;
    private int quantity;
    private BigDecimal price;
    private String name;

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LineItem(String itemId, int quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }
    public LineItem(String item){
        this(item,1);
    }
    public String getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineItem lineItem = (LineItem) o;
        return quantity == lineItem.quantity && Objects.equals(itemId, lineItem.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, quantity);
    }

    public void reduceQuantityBy(int quantityToReduceBy) {
        this.quantity -=quantityToReduceBy;

    }
    public BigDecimal totalPrice(){
        return price.multiply(BigDecimal.valueOf(quantity));
    }
}
