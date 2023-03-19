package com.rudderstack.assignment.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rudderstack.assignment.modal.Event;
import com.rudderstack.assignment.repository.EventRulesRepo;
import com.rudderstack.assignment.repository.TrackingPlanRepo;
import com.rudderstack.assignment.repository.dao.EventRules;
import com.rudderstack.assignment.repository.dao.TrackingPlan;
import com.rudderstack.assignment.service.ProcessEvents;
import com.rudderstack.assignment.service.ProcessTrackingPlan;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class RestControllerTest {
    @Autowired
    MockMvc mockMvc;

    @TestConfiguration
    public static class Context{
        @Bean
        public ProcessEvents getProcessEvents() {
            return new ProcessEvents() {
                @Override
                public List<String> getTrackingPlans(Event event) throws Exception {
                    return new ArrayList<>();
                }

                @Override
                public Event addEvent(Event event) throws JsonProcessingException {
                    return new Event();
                }
            };
        }

        @Bean
        public ProcessTrackingPlan getProcessTrackingPlan(){
            return new ProcessTrackingPlan(){
                @Override
                public TrackingPlan addTrackingPlan(TrackingPlan trackingPlan) {
                    return new TrackingPlan();
                }

                @Override
                public TrackingPlan getTrackingPlanByDisplayName(String displayName) {
                    return new TrackingPlan();
                }

                @Override
                public List<TrackingPlan> getAllTrackingPlan(){
                    return Collections.emptyList();
                }
            };
        }

        @Bean
        public EventRulesRepo getEventRulesRepo(){
            return new EventRulesRepo() {
                @Override
                public List<EventRules> findAll() {
                    return null;
                }

                @Override
                public List<EventRules> findAll(Sort sort) {
                    return null;
                }

                @Override
                public List<EventRules> findAllById(Iterable<String> strings) {
                    return null;
                }

                @Override
                public <S extends EventRules> List<S> saveAll(Iterable<S> entities) {
                    return null;
                }

                @Override
                public void flush() {

                }

                @Override
                public <S extends EventRules> S saveAndFlush(S entity) {
                    return null;
                }

                @Override
                public <S extends EventRules> List<S> saveAllAndFlush(Iterable<S> entities) {
                    return null;
                }

                @Override
                public void deleteAllInBatch(Iterable<EventRules> entities) {

                }

                @Override
                public void deleteAllByIdInBatch(Iterable<String> strings) {

                }

                @Override
                public void deleteAllInBatch() {

                }

                @Override
                public EventRules getOne(String s) {
                    return null;
                }

                @Override
                public EventRules getById(String s) {
                    return null;
                }

                @Override
                public EventRules getReferenceById(String s) {
                    return null;
                }

                @Override
                public <S extends EventRules> List<S> findAll(Example<S> example) {
                    return null;
                }

                @Override
                public <S extends EventRules> List<S> findAll(Example<S> example, Sort sort) {
                    return null;
                }

                @Override
                public Page<EventRules> findAll(Pageable pageable) {
                    return null;
                }

                @Override
                public <S extends EventRules> S save(S entity) {
                    return null;
                }

                @Override
                public Optional<EventRules> findById(String s) {
                    return Optional.empty();
                }

                @Override
                public boolean existsById(String s) {
                    return false;
                }

                @Override
                public long count() {
                    return 0;
                }

                @Override
                public void deleteById(String s) {

                }

                @Override
                public void delete(EventRules entity) {

                }

                @Override
                public void deleteAllById(Iterable<? extends String> strings) {

                }

                @Override
                public void deleteAll(Iterable<? extends EventRules> entities) {

                }

                @Override
                public void deleteAll() {

                }

                @Override
                public <S extends EventRules> Optional<S> findOne(Example<S> example) {
                    return Optional.empty();
                }

                @Override
                public <S extends EventRules> Page<S> findAll(Example<S> example, Pageable pageable) {
                    return null;
                }

                @Override
                public <S extends EventRules> long count(Example<S> example) {
                    return 0;
                }

                @Override
                public <S extends EventRules> boolean exists(Example<S> example) {
                    return false;
                }

                @Override
                public <S extends EventRules, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                    return null;
                }
            };
        }
        @Bean
        public TrackingPlanRepo trackingPlanRepo(){
            return  new TrackingPlanRepo() {
                @Override
                public List<TrackingPlan> findAll() {
                    return null;
                }

                @Override
                public List<TrackingPlan> findAll(Sort sort) {
                    return null;
                }

                @Override
                public List<TrackingPlan> findAllById(Iterable<String> strings) {
                    return null;
                }

                @Override
                public <S extends TrackingPlan> List<S> saveAll(Iterable<S> entities) {
                    return null;
                }

                @Override
                public void flush() {

                }

                @Override
                public <S extends TrackingPlan> S saveAndFlush(S entity) {
                    return null;
                }

                @Override
                public <S extends TrackingPlan> List<S> saveAllAndFlush(Iterable<S> entities) {
                    return null;
                }

                @Override
                public void deleteAllInBatch(Iterable<TrackingPlan> entities) {

                }

                @Override
                public void deleteAllByIdInBatch(Iterable<String> strings) {

                }

                @Override
                public void deleteAllInBatch() {

                }

                @Override
                public TrackingPlan getOne(String s) {
                    return null;
                }

                @Override
                public TrackingPlan getById(String s) {
                    return null;
                }

                @Override
                public TrackingPlan getReferenceById(String s) {
                    return null;
                }

                @Override
                public <S extends TrackingPlan> List<S> findAll(Example<S> example) {
                    return null;
                }

                @Override
                public <S extends TrackingPlan> List<S> findAll(Example<S> example, Sort sort) {
                    return null;
                }

                @Override
                public Page<TrackingPlan> findAll(Pageable pageable) {
                    return null;
                }

                @Override
                public <S extends TrackingPlan> S save(S entity) {
                    return null;
                }

                @Override
                public Optional<TrackingPlan> findById(String s) {
                    return Optional.empty();
                }

                @Override
                public boolean existsById(String s) {
                    return false;
                }

                @Override
                public long count() {
                    return 0;
                }

                @Override
                public void deleteById(String s) {

                }

                @Override
                public void delete(TrackingPlan entity) {

                }

                @Override
                public void deleteAllById(Iterable<? extends String> strings) {

                }

                @Override
                public void deleteAll(Iterable<? extends TrackingPlan> entities) {

                }

                @Override
                public void deleteAll() {

                }

                @Override
                public <S extends TrackingPlan> Optional<S> findOne(Example<S> example) {
                    return Optional.empty();
                }

                @Override
                public <S extends TrackingPlan> Page<S> findAll(Example<S> example, Pageable pageable) {
                    return null;
                }

                @Override
                public <S extends TrackingPlan> long count(Example<S> example) {
                    return 0;
                }

                @Override
                public <S extends TrackingPlan> boolean exists(Example<S> example) {
                    return false;
                }

                @Override
                public <S extends TrackingPlan, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                    return null;
                }
            };
        }
    }

    @Test
    public void test1() throws Exception {
        this.mockMvc.perform(post("/api/trackingPlan/add")
                .content("{\n" +
                        "    \"name\": \"Tracking Plan-1\",\n" +
                        "    \n" +
                        "    \"events\": [\n" +
                        "        {\n" +
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
                        "        \n" +
                        "    ]\n" +
                        "        \n" +
                        "}").accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void test2() throws Exception {
        this.mockMvc.perform(get("/api/trackingPlan/get/all")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void test3() throws Exception {
        this.mockMvc.perform(post("/api/events/add")
                .content("{\n" +
                        "\t\"name\": \"Order Viewed\",\n" +
                        "  \"properties\": {\n" +
                        "       \"product\": \"ap1\",\n" +
                        "       \"price\": \"10\",\n" +
                        "       \"currency\": \"INR\"\n" +
                        "   }\n" +
                        "}")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void test4() throws Exception {
        this.mockMvc.perform(post("/api/events/get")
                .content("{\n" +
                        "\t\"name\": \"Order Viewed\",\n" +
                        "  \"properties\": {\n" +
                        "       \"product\": \"ap1\",\n" +
                        "       \"price\": \"10\",\n" +
                        "       \"currency\": \"INR\"\n" +
                        "   }\n" +
                        "}")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

}
