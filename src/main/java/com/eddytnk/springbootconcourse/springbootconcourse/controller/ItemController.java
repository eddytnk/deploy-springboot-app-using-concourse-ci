package com.eddytnk.springbootconcourse.springbootconcourse.controller;

import com.eddytnk.springbootconcourse.springbootconcourse.model.Item;
import com.eddytnk.springbootconcourse.springbootconcourse.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @GetMapping("/")
    String sayHello(){
        return "Hello World!";
    }

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public ResponseEntity<List<Item> >getItems(){
        List<Item> items = itemService.getItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
}
