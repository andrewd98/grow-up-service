package com.adresser98.grow_up.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Task {

    @JsonProperty
    private String taskGroup;
    @JsonProperty
    private String task;

}
