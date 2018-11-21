package com.eddytnk.springbootconcourse.springbootconcourse.repository;

import com.eddytnk.springbootconcourse.springbootconcourse.model.Item;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class ItemRepositoryTest {

    private ItemRepository itemRepository = new ItemRepository();

    @Test
    public void findAllItems_return_a_list_of_items(){
        List<Item> allItems = itemRepository.findAllItems();
        assertThat(allItems.size()).isEqualTo(2);
    }
}
