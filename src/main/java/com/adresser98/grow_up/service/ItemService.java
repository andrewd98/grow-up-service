package com.adresser98.grow_up.service;

import com.adresser98.grow_up.api.Item;
import com.adresser98.grow_up.api.ItemGroup;
import com.adresser98.grow_up.api.Items;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
public class ItemService {

    @Autowired
    private ItemManager itemManager;

    public Set<String> addItem(Item item) {
        return itemManager.addItemToGroup(item.getItemGroup(), item.getItem());
    }

    public Set<String> addItems(Items items) {
        items.getItems().forEach(item -> itemManager.addItemToGroup(items.getItemGroup(), item));
        return itemManager.getItemsByGroup(items.getItemGroup());
    }


    public Set<String> getItemsByGroup(String itemGroup) {
        return itemManager.getItemsByGroup(itemGroup);
    }

    public Set<String> deleteItem(Item deleteItem) {
        return itemManager.deleteItem(deleteItem.getItemGroup(), deleteItem.getItem());
    }

    public boolean deleteItemGroup(ItemGroup itemGroup) {
        return itemManager.deleteItemGroup(itemGroup.getItemGroup());
    }

}
