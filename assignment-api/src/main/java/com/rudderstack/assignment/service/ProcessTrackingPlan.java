package com.rudderstack.assignment.service;

import com.rudderstack.assignment.repository.EventRulesRepo;
import com.rudderstack.assignment.repository.TrackingPlanRepo;
import com.rudderstack.assignment.repository.dao.EventRules;
import com.rudderstack.assignment.repository.dao.TrackingPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcessTrackingPlan {

    @Autowired
    private TrackingPlanRepo trackingPlanRepo;

    @Autowired
    private EventRulesRepo eventRulesRepo;

    /**
     * Tracking plans and events have many to many relation
     * So in order to add a new tracking plan , relations have to be updated and then a new tracking plan has to be added
     * @param trackingPlan
     * @return
     */
    public TrackingPlan addTrackingPlan(TrackingPlan trackingPlan) {
        Optional<TrackingPlan> trackingPlanOptional = trackingPlanRepo.findById(trackingPlan.getDisplayName());
        trackingPlanOptional.ifPresent(plan -> {
            List<EventRules> events = plan.getEvents();
            for (int i = 0, eventsSize = events.size(); i < eventsSize; i++) {
                EventRules element = events.get(i);
                if (!trackingPlan.getEvents().contains(element)) {
                    element.getTrackingPlans().remove(plan);
                    eventRulesRepo.save(element);
                    plan.getEvents().remove(element);
                }
            }
            trackingPlanRepo.save(plan);
        });
        int size = trackingPlan.getEvents().size();
        for(int i = 0;i<size;i++){
            EventRules eventRules = trackingPlan.getEvents().get(i);
            Optional<EventRules> dto = eventRulesRepo.findById(eventRules.getName());
            if(dto.isPresent())
                trackingPlan.getEvents().set(i,dto.get());
        }
        trackingPlan.getEvents().forEach(eventRules -> {
            eventRules.getTrackingPlans().add(trackingPlan);
        });
        return trackingPlanRepo.save(trackingPlan);
    }


    /**
     * Gets tracking plan for a particular event id
     * @param displayName
     * @return
     */
    public TrackingPlan getTrackingPlanByDisplayName(String displayName) {
        Optional<TrackingPlan> trackingPlanOptional = trackingPlanRepo.findById(displayName);
        return trackingPlanOptional.orElse(null);
    }

    /**
     * Gets all tracking plans
     * @return
     */
    public List<TrackingPlan> getAllTrackingPlan(){
        return trackingPlanRepo.findAll();
    }
}
