package com.rudderstack.assignment.service;

import com.rudderstack.assignment.repository.EventRulesRepo;
import com.rudderstack.assignment.repository.TrackingPlanRepo;
import com.rudderstack.assignment.repository.dao.EventRules;
import com.rudderstack.assignment.repository.dao.TrackingPlan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProcessTrackingPlanTest {

    @Mock
    private TrackingPlanRepo trackingPlanRepo;

    @Mock
    private EventRulesRepo eventRulesRepo;

    @InjectMocks
    private ProcessTrackingPlan processTrackingPlan;

    @Test
    public void test1() {
        Mockito.doReturn(new ArrayList<>()).when(trackingPlanRepo).findAll();
        Assertions.assertEquals(processTrackingPlan.getAllTrackingPlan().size(),0);
    }

    @Test
    public void test2(){
        Mockito.doReturn(Optional.empty()).when(trackingPlanRepo).findById(Mockito.anyString());
        Assertions.assertEquals(processTrackingPlan.getTrackingPlanByDisplayName("asdasdas"),null);

    }

    @Test
    public void test3() {
        TrackingPlan trackingPlan = new TrackingPlan();
        trackingPlan.getEvents().add(new EventRules());
        trackingPlan.getEvents().get(0).setName("sdfasdasdad");
        trackingPlan.setDisplayName("sdasdasdasdasd");
        Mockito.doReturn(Optional.empty()).when(trackingPlanRepo).findById(Mockito.anyString());
        Mockito.doReturn(Optional.empty()).when(eventRulesRepo).findById(Mockito.anyString());
        Assertions.assertEquals(processTrackingPlan.addTrackingPlan(trackingPlan), null);
    }

    @Test
    public void test4(){
        TrackingPlan trackingPlan = new TrackingPlan();
        trackingPlan.getEvents().add(new EventRules());
        trackingPlan.getEvents().get(0).setName("sdfasdasdad");
        trackingPlan.setDisplayName("sdasdasdasdasd");
        Mockito.doReturn(Optional.of(trackingPlan)).when(trackingPlanRepo).findById(Mockito.anyString());
        Mockito.doReturn(Optional.empty()).when(eventRulesRepo).findById(Mockito.anyString());
        Assertions.assertEquals(processTrackingPlan.addTrackingPlan(trackingPlan),null);
    }

    @Test
    public void test5(){
        TrackingPlan trackingPlan = new TrackingPlan();
        trackingPlan.getEvents().add(new EventRules());
        trackingPlan.getEvents().get(0).setName("sdfasdasdad");
        trackingPlan.setDisplayName("sdasdasdasdasd");
        TrackingPlan trackingPlan2 = new TrackingPlan();
        trackingPlan2.getEvents().add(new EventRules());
        trackingPlan2.getEvents().get(0).setName("sdfasdasda12d");
        trackingPlan2.setDisplayName("sdasdasdasdasd");
        Mockito.doReturn(Optional.of(trackingPlan)).when(trackingPlanRepo).findById(Mockito.anyString());
        Mockito.doReturn(null).when(eventRulesRepo).save(Mockito.any());
        Assertions.assertEquals(processTrackingPlan.addTrackingPlan(trackingPlan2),null);
    }

}
