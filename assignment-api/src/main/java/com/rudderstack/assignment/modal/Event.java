package com.rudderstack.assignment.modal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

@Data
public class Event {
    private String name;
    private String properties;

    private static ObjectMapper objectMapper = new ObjectMapper();

    @JsonProperty("properties")
    public void setProperties(Object properties) throws JsonProcessingException {
        this.properties = objectMapper.writeValueAsString(properties);
    }
}
