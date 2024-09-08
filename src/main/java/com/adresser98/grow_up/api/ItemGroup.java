package com.adresser98.grow_up.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemGroup {

    @JsonProperty
    private String itemGroup;
}
