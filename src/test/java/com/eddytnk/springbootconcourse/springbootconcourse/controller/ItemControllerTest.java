package com.eddytnk.springbootconcourse.springbootconcourse.controller;


import com.eddytnk.springbootconcourse.springbootconcourse.model.Item;
import com.eddytnk.springbootconcourse.springbootconcourse.service.ItemService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @MockBean
    private ItemService mockItemService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void getItems_returns_all_items() throws Exception {

        Item item = new Item();
        item.setId(1L);
        item.setItemName("Phone");

        when(mockItemService.getItems()).thenReturn(Arrays.asList(item));

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/items"))
                .andExpect(status().isOk())
                .andReturn();


        List<Item> actualItems = objectMapper.readValue(mvcResult.getResponse().getContentAsByteArray(),
                new TypeReference<List<Item>>(){});

        verify(mockItemService).getItems();
        assertThat(actualItems.get(0)).isEqualTo(item);

    }

}
