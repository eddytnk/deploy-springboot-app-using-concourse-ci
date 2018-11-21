package com.eddytnk.springbootconcourse.springbootconcourse.model;


import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ItemTest {
    private Item item  = new Item();

    private Long id = 12L;
    private String itemName = "Laptop";
    private int quantity = 15;
    private double price = 1500;


    @Before
    public void setUp(){
        item.setId(id);
        item.setItemName(itemName);
        item.setQuantity(quantity);
        item.setPrice(price);
    }

    @Test
    public void test_getters_setters(){
        assertThat(item.getId()).isEqualTo(id);
        assertThat(item.getItemName()).isEqualTo(itemName);
        assertThat(item.getQuantity()).isEqualTo(quantity);
        assertThat(item.getPrice()).isEqualTo(price);
    }
}
