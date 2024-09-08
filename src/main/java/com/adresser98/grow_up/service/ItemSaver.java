package com.adresser98.grow_up.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@Aspect
@Slf4j
@Component
public class ItemSaver {

    @Value("${grow-up.application.save.file-location}")
    private String saveFileLocation;
    @Autowired
    private Map<String, Set<String>> itemsByGroup;
    @Autowired
    private ObjectMapper mapper;

    @After("execution(* com.adresser98.grow_up.service.ItemManager.*(..))")
    private void saveItems() throws IOException {
        log.info("saveTasks: Saving Items");
        mapper.writeValue(new File(saveFileLocation), itemsByGroup);
    }

}
