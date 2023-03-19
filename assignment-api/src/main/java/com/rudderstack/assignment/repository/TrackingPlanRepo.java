package com.rudderstack.assignment.repository;

import com.rudderstack.assignment.repository.dao.TrackingPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Repository to add a tracking plan to the table
 */
@Repository
public interface TrackingPlanRepo extends JpaRepository<TrackingPlan,String> {
}
