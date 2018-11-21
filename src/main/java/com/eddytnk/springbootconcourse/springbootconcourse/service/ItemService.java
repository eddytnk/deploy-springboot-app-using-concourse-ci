package com.eddytnk.springbootconcourse.springbootconcourse.service;

import com.eddytnk.springbootconcourse.springbootconcourse.model.Item;
import com.eddytnk.springbootconcourse.springbootconcourse.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getItems() {
        return itemRepository.findAllItems();
    }
}
