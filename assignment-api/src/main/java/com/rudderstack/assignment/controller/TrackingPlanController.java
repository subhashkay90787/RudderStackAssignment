package com.rudderstack.assignment.controller;

import com.rudderstack.assignment.repository.dao.TrackingPlan;
import com.rudderstack.assignment.service.ProcessTrackingPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trackingPlan")
public class TrackingPlanController {

    @Autowired
    private ProcessTrackingPlan processTrackingPlan;

    /**
     * Adds the tracking plan to the database
     * @param trackingPlan
     * @return
     */
    @PostMapping("/add")
    public TrackingPlan addTrackingPlan(@RequestBody TrackingPlan trackingPlan) {
        return processTrackingPlan.addTrackingPlan(trackingPlan);
    }

    /**
     * Fetches all the tracking plans from the database
     * @return
     */
    @GetMapping("/get/all")
    public List<TrackingPlan> getAllTrackingPlan(){
        return processTrackingPlan.getAllTrackingPlan();
    }

}
