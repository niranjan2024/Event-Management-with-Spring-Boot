package com.eventmanagement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.eventmanagement.entity.Event;
import com.eventmanagement.exception.EventNotFoundException;
import com.eventmanagement.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {

    private static final Logger log =
            LoggerFactory.getLogger(EventServiceImpl.class);

    private final EventRepository repository;

    public EventServiceImpl(EventRepository repository) {
        this.repository = repository;
    }

    @Override
    public Event createEvent(Event event) {
        log.debug("Creating event: {}", event);
        Event savedEvent = repository.save(event);
        log.info("Event created successfully with id: {}", savedEvent.getId());
        return savedEvent;
    }

    @Override
    public List<Event> getAllEvents() {
        log.debug("Fetching all events from database");
        List<Event> events = repository.findAll();
        log.info("Fetched {} events", events.size());
        return events;
    }

    @Override
    public Event getEventById(Long id) {
        log.debug("Fetching event with id: {}", id);
        return repository.findById(id)
                .orElseThrow(() -> {
                    log.error("Event not found with id: {}", id);
                    return new EventNotFoundException("Event not found with id " + id);
                });
    }

    @Override
    public Event updateEvent(Long id, Event event) {
        log.info("Updating event with id: {}", id);
        Event existing = getEventById(id);

        existing.setName(event.getName());
        existing.setLocation(event.getLocation());
        existing.setDate(event.getDate());
        existing.setOrganizer(event.getOrganizer());

        Event updatedEvent = repository.save(existing);
        log.info("Event updated successfully with id: {}", updatedEvent.getId());
        return updatedEvent;
    }

    @Override
    public void deleteEvent(Long id) {
        log.warn("Deleting event with id: {}", id);
        Event event = getEventById(id);
        repository.delete(event);
        log.info("Event deleted successfully with id: {}", id);
    }
}
