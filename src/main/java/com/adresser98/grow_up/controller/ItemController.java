package com.adresser98.grow_up.controller;

import com.adresser98.grow_up.api.Item;
import com.adresser98.grow_up.api.ItemGroup;
import com.adresser98.grow_up.api.Items;
import com.adresser98.grow_up.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/add-item")
    public ResponseEntity addItem(@RequestBody Item addItem) {
        return ResponseEntity.ok(itemService.addItem(addItem));
    }

    @PostMapping("/add-items")
    public ResponseEntity addItems(@RequestBody Items addItems) {
        return ResponseEntity.ok(itemService.addItems(addItems));
    }

    @GetMapping("/get-items")
    public ResponseEntity getItems(@RequestParam String itemGroup) {
        return ResponseEntity.ok(itemService.getItemsByGroup(itemGroup));
    }

    @PostMapping("/delete-item")
    public ResponseEntity deleteItem(@RequestBody Item deleteItem) {
        return ResponseEntity.ok(itemService.deleteItem(deleteItem));
    }

    @PostMapping("/delete-item-group")
    public ResponseEntity deleteItemGroup(@RequestBody ItemGroup itemGroup) {
        return ResponseEntity.ok(itemService.deleteItemGroup(itemGroup));
    }

}
