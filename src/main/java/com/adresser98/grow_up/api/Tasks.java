package com.adresser98.grow_up.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Tasks {

    @JsonProperty
    private String taskGroup;
    @JsonProperty
    private List<String> tasks;
}
