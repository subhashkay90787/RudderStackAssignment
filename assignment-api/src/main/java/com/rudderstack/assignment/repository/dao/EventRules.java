package com.rudderstack.assignment.repository.dao;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Table(name = "EVENT")
@Entity
@EqualsAndHashCode(of="name")
public class EventRules {

    private static ObjectMapper objectMapper = new ObjectMapper();
    @Id
    private String name;
    private String description;
    @Lob
    private String rules;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<TrackingPlan> trackingPlans;

    public Set<TrackingPlan> getTrackingPlans() {
        if(trackingPlans==null)
            trackingPlans = new HashSet<>();
        return trackingPlans;
    }

    @JsonProperty("rules")
    public void setRules(Object rules) throws JsonProcessingException {
        this.rules = objectMapper.writeValueAsString(rules);
    }
}
