package com.adresser98.grow_up.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Items {

    @JsonProperty
    private String itemGroup;
    @JsonProperty
    private List<String> items;
}
