package com.rudderstack.assignment.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import com.rudderstack.assignment.modal.Event;
import com.rudderstack.assignment.repository.EventRulesRepo;
import com.rudderstack.assignment.repository.dao.EventRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProcessEvents {

    @Autowired
    private EventRulesRepo eventsRepo;

    private JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
    private ObjectMapper objectMapper = new ObjectMapper();


    /**
     * Pulls the plans for the events and then validates the schema against the event.
     * If it passes the validation then the tracking plans attached to the events are returned
     * @param event
     * @return
     * @throws Exception
     */
    public List<String> getTrackingPlans(Event event) throws Exception {
        Optional<EventRules> eventRules = eventsRepo.findById(event.getName());
        List<String> trackingPlans = new ArrayList<>();
        if(!eventRules.isEmpty()){
            EventRules rules = eventRules.get();
            JsonSchema schema = factory.getSchema((String) rules.getRules());
            Set<ValidationMessage> messageSet = schema.validate(objectMapper.readTree(event.getProperties()));
            if(!messageSet.isEmpty()){
                return trackingPlans;
            }
            return rules.getTrackingPlans().stream().map(elem->elem.getDisplayName()).collect(Collectors.toList());
        }
        return trackingPlans;
    }

    /**
     * Checks for the existence of the event in the database and then adds the event
     * @param event
     * @return
     * @throws JsonProcessingException
     */

    public Event addEvent(Event event) throws JsonProcessingException {
        if(eventsRepo.findById(event.getName()).isPresent()){
            return event;
        }
        EventRules eventRules = new EventRules();
        eventRules.setName(event.getName());
        eventRules.setRules(event.getProperties());
        eventsRepo.save(eventRules);
        return event;
    }



}
