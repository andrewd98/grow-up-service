package com.adresser98.grow_up.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
@Configuration
public class GrowUpConfig {

    @Value("${grow-up.application.save.file-location}")
    private String saveFileLocation;

    @Bean
    ObjectMapper mapper() {
        return new ObjectMapper();
    }

    @Bean
    Map<String, Set<String>> itemssByGroup(@Autowired ObjectMapper mapper) {
        try {
            TypeReference<Map<String, Set<String>>> typeRef = new TypeReference<>(){};
            Map<String, Set<String>> savedItemsByGroup = mapper.readValue(new File(saveFileLocation), typeRef);
            log.info("tasksByGroup: found {} task groups", savedItemsByGroup.size());
            return savedItemsByGroup;
        } catch (IOException e) {
            log.info("tasksByGroup: No tasks file found at location={}", saveFileLocation);
            return new HashMap<>();
        }

    }

}
