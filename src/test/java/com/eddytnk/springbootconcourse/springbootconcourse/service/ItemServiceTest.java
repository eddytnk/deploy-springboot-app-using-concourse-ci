package com.eddytnk.springbootconcourse.springbootconcourse.service;

import com.eddytnk.springbootconcourse.springbootconcourse.model.Item;
import com.eddytnk.springbootconcourse.springbootconcourse.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {


    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    @Test
    public void getItems_returns_a_list_of_items(){
        when(itemRepository.findAllItems()).thenReturn(Arrays.asList(new Item()));

        List<Item> items =itemService.getItems();
        verify(itemRepository).findAllItems();
        assertThat(items.size()).isEqualTo(1);
    }
}
