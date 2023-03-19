package com.rudderstack.assignment.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rudderstack.assignment.modal.Event;
import com.rudderstack.assignment.repository.EventRulesRepo;
import com.rudderstack.assignment.repository.dao.EventRules;
import com.rudderstack.assignment.repository.dao.TrackingPlan;
import org.hibernate.mapping.Collection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProcessEventsTest {

    @Mock
    private EventRulesRepo eventRulesRepo;


    @InjectMocks
    private ProcessEvents processEvents;

    @Test
    public void test1() throws JsonProcessingException {
//        Mockito.doReturn(Optional.of(new EventRules())).when(eventRulesRepo).findById(Mockito.anyString());
        Mockito.doReturn(new EventRules()).when(eventRulesRepo).save(Mockito.any());
        Event event = new Event();
        Assertions.assertEquals(processEvents.addEvent(event),event);
    }
    @Test
    public void test2() throws JsonProcessingException {
        Mockito.doReturn(Optional.of(new EventRules())).when(eventRulesRepo).findById(Mockito.anyString());
        Event event = new Event();
        event.setName("q34234234");
        Assertions.assertEquals(processEvents.addEvent(event),event);
    }

    @Test
    public void test3() throws Exception {

        Event event = new Event();
        event.setName("q34234234");
        event.setProperties("{\n" +
                "       \"product\": \"ap1\",\n" +
                "       \"price\": \"10\",\n" +
                "       \"currency\": \"INR\"\n" +
                "   }");
        EventRules eventRules = new EventRules();
        eventRules.setName("q34234234");
        eventRules.setRules("{\n" +
                "            \"name\": \"Order Viewed\",\n" +
                "            \"description\": \"Whose order viewed\",\n" +
                "            \"rules\": {\n" +
                "                \"$schema\": \"http://json-schema.org/draft-07/schema#\",\n" +
                "                \"type\": \"object\",\n" +
                "                \"properties\": {\n" +
                "                    \"type\": \"object\",\n" +
                "                    \"properties\": {\n" +
                "                        \"product\": {\n" +
                "                        \"type\": [\"string\"]\n" +
                "                        },\n" +
                "                        \"price\": {\n" +
                "                        \"type\": [\"number\"]\n" +
                "                        },\n" +
                "                        \"currency\": {\n" +
                "                        \"type\": [\"string\"]\n" +
                "                        }\n" +
                "                    }, \n" +
                "                    \"required\": [\n" +
                "                    \"product\",\n" +
                "                    \"price\",\n" +
                "                    \"currency\"\n" +
                "                    ]\n" +
                "            }\n" +
                "            }\n" +
                "        }\n" +
                "        ");
        TrackingPlan trackingPlan = new TrackingPlan();
        trackingPlan.setDisplayName("qwrqwr");
        eventRules.getTrackingPlans().add(trackingPlan);
        Mockito.doReturn(Optional.of(eventRules)).when(eventRulesRepo).findById(Mockito.anyString());
        Assertions.assertEquals(processEvents.getTrackingPlans(event).size(), 1);
    }


}
