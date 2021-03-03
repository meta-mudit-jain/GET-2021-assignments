package com.shoppingcart;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ShoppingCart {
    private final Inventory inventory;
    private List<LineItem> itemsInCart = new ArrayList<>();

    public ShoppingCart(Inventory inventory) {
        this.inventory=inventory;
    }

    public void addItem(LineItem lineitem) {
        Item item=inventory.get(lineitem.getItemId());
        lineitem.setName(item.getName());
        lineitem.setPrice(item.getPrice());
        this.itemsInCart.add(lineitem);
    }

    public int totalNumberOfItems() {
        int totalItem=0;
        for(LineItem lineItem: itemsInCart){
            totalItem+=lineItem.getQuantity();
        }
        return totalItem;
    }

    public void remove(LineItem lineItemToRemove) {
        boolean deleteLineItem = false;
        for (LineItem itemInCart : itemsInCart) {
            if (itemInCart.getItemId() == lineItemToRemove.getItemId()) {
                if (itemInCart.getQuantity() == lineItemToRemove.getQuantity()) {
                    deleteLineItem = true;
                } else {
                    itemInCart.reduceQuantityBy(lineItemToRemove.getQuantity());
                }
            }
        }
        if (deleteLineItem) {
            this.itemsInCart.remove(lineItemToRemove);
        }
    }

    public List<LineItem> listItemsInCart() {
        return Collections.unmodifiableList(this.itemsInCart);
    }
}
