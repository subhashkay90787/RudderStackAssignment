package com.rudderstack.assignment.repository;

import com.rudderstack.assignment.repository.dao.EventRules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository to add events to the table
 */
@Repository
public interface EventRulesRepo extends JpaRepository<EventRules,String> {
}
