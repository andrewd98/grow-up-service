package com.adresser98.grow_up.service;

import com.adresser98.grow_up.api.Items;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Slf4j
@Component
public class ItemManager {

    @Autowired
    private Map<String, Set<String>> itemsByGroup;

    public Set<String> addItemToGroup(String itemGroup, String item) {
        itemsByGroup.computeIfAbsent(itemGroup, t -> new HashSet<>());
        itemsByGroup.get(itemGroup).add(item);

        return itemsByGroup.get(itemGroup);
    }

    public Set<String> addItemsToGroup(Items tasks) {
        itemsByGroup.computeIfAbsent(tasks.getItemGroup(), t -> new HashSet<>());
        tasks.getItems().forEach(task -> itemsByGroup.get(tasks.getItemGroup()).add(task));

        return itemsByGroup.get(tasks.getItemGroup());
    }

    public Set<String> getItemsByGroup(String taskGroup) {
        return itemsByGroup.getOrDefault(taskGroup, new HashSet<>());
    }

    public Set<String> deleteItem(String itemGroup, String item) {
        if (itemsByGroup.containsKey(itemGroup)) {
            itemsByGroup.get(itemGroup).remove(item);
            return itemsByGroup.get(itemGroup);
        }
        return new HashSet<>();
    }

    public boolean deleteItemGroup(String itemGroup) {
        if (itemsByGroup.containsKey(itemGroup)) {
            itemsByGroup.remove(itemGroup);
            return true;
        }
        log.info("deleteTaskGroup: itemGroup={} does not exist. Available task groups={}", itemGroup, itemsByGroup.keySet());
        return false;
    }


}
