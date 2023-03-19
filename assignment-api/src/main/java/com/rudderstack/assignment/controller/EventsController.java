package com.rudderstack.assignment.controller;

import com.rudderstack.assignment.modal.Event;
import com.rudderstack.assignment.service.ProcessEvents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventsController {

    @Autowired
    private ProcessEvents processEvents;

    /**
     * Gets all the tracking plans for the event Provided
     *
     * @param event
     * @return
     * @throws Exception
     */
    @PostMapping("/get")
    public List<String> getTrackingPlans(@RequestBody Event event) throws Exception {
        return processEvents.getTrackingPlans(event);
    }

    /**
     * Adds event to the database
     * @param event
     * @return
     * @throws Exception
     */
    @PostMapping("/add")
    public Event addEvent(@RequestBody Event event) throws Exception {
        return processEvents.addEvent(event);
    }
}
