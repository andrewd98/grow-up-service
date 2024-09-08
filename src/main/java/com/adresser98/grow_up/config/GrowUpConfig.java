package com.adresser98.grow_up.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Configuration
public class GrowUpConfig {

    @Bean
    Map<String, Set<String>> tasksByGroup() {
        return new HashMap<>();
    }

}
