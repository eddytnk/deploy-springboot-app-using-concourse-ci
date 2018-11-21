package com.eddytnk.springbootconcourse.springbootconcourse.repository;

import com.eddytnk.springbootconcourse.springbootconcourse.model.Item;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ItemRepository {

    public List<Item> findAllItems() {

        Item item1 = new Item();
        item1.setId(1L);
        item1.setItemName("TV");
        item1.setQuantity(11);
        item1.setPrice(600.00);

        Item item2 = new Item();
        item2.setId(2L);
        item2.setItemName("Table");
        item2.setQuantity(2);
        item2.setPrice(100.00);

        return Arrays.asList(item1,item2);
    }
}
