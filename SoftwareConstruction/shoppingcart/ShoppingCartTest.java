package com.shoppingcart;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;


public class ShoppingCartTest {
    private Inventory inventory;
    private ShoppingCart cart;
    @Before
    public void setUp() throws Exception{
        Item item1=new Item("item-1","Effective Java",ItemType.BOOK, BigDecimal.valueOf(4000));
        Item item2=new Item("item-2","Pen",ItemType.PEN, BigDecimal.valueOf(250));
        inventory = new Inventory();
        inventory.add(item1);
        inventory.add(item2);
        cart =new ShoppingCart(inventory);
    }
    @Test
    public void should_add_an_item_to_a_cart(){


        cart.addItem(new LineItem("item-1"));

        int totalItemCount=cart.totalNumberOfItems();
        assertEquals(1,totalItemCount);
    }
    @Test
    public void should_add_multiple_item_to_the_cart(){
        cart.addItem(new LineItem("item-1"));
        cart.addItem(new LineItem("item-2"));
        int totalItemCount=cart.totalNumberOfItems();
        assertEquals(2,totalItemCount);
    }
    @Test
    public void should_add_multiple_quantity_of_the_same_item_to_the_cart(){

        cart.addItem(new LineItem("item-1",2));
        int totalItemCount=cart.totalNumberOfItems();
        assertEquals(2,totalItemCount);
    }
    @Test
    public void should_remove_an_item_from_the_cart(){
        cart.addItem(new LineItem("item-1"));
        cart.addItem(new LineItem("item-2"));

        cart.remove(new LineItem(("item-1")));

        int totalItemCount=cart.totalNumberOfItems();
        assertEquals(1,totalItemCount);
    }

    @Test
    public void should_remove_specific_quantity_of_an_item_from_the_cart(){
        cart.addItem(new LineItem("item-1",4));
        cart.addItem(new LineItem("item-2",3));

        cart.remove(new LineItem("item-1",2));
        cart.remove(new LineItem("item-2",1));
        int totalItemCount=cart.totalNumberOfItems();
        assertEquals(4,totalItemCount);
    }

    @Test
    public void should_view_listing_of_items_in_the_cart(){
        cart.addItem(new LineItem("item-1",4));
        cart.addItem(new LineItem("item-2",3));
        List<LineItem> lineItems =cart.listItemsInCart();
        assertEquals(BigDecimal.valueOf(16000),lineItems.get(0).totalPrice());
        assertEquals(BigDecimal.valueOf(750),lineItems.get(1).totalPrice());
    }

}