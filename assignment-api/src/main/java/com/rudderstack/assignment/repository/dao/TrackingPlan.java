package com.rudderstack.assignment.repository.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "TRACKING_PLAN")
@Entity
public class TrackingPlan {

    @Id
    @JsonProperty("name")
    private String displayName;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<EventRules> events;


    public List<EventRules> getEvents() {
        if(this.events==null)
            this.events = new ArrayList<>();
        return this.events;
    }
}
