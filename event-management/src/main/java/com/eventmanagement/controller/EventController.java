package com.eventmanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import com.eventmanagement.entity.Event;
import com.eventmanagement.service.EventService;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private static final Logger log =
            LoggerFactory.getLogger(EventController.class);

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @PostMapping
    public Event create(@RequestBody Event event) {
        log.info("Request received to create event: {}", event.getName());
        Event createdEvent = service.createEvent(event);
        log.info("Event created successfully with id: {}", createdEvent.getId());
        return createdEvent;
    }

    @GetMapping
    public List<Event> getAll() {
        log.info("Request received to fetch all events");
        List<Event> events = service.getAllEvents();
        log.debug("Total events fetched: {}", events.size());
        return events;
    }

    @GetMapping("/{id}")
    public Event getById(@PathVariable Long id) {
        log.info("Request received to fetch event with id: {}", id);
        return service.getEventById(id);
    }

    @PutMapping("/{id}")
    public Event update(@PathVariable Long id, @RequestBody Event event) {
        log.info("Request received to update event with id: {}", id);
        Event updatedEvent = service.updateEvent(id, event);
        log.info("Event updated successfully with id: {}", updatedEvent.getId());
        return updatedEvent;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        log.warn("Request received to delete event with id: {}", id);
        service.deleteEvent(id);
        log.info("Event deleted successfully with id: {}", id);
        return "Event deleted successfully";
    }
}
