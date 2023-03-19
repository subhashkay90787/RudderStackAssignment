package com.rudderstack.assignment;

import com.rudderstack.assignment.controller.EventsController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AssignmentApplicationTest {

    @Autowired
    private EventsController assignment1;
    @Test
    public void contextLoads(){
        Assertions.assertNotNull(assignment1);
    }

}
