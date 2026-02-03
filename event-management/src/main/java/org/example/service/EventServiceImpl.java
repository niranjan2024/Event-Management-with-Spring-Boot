package org.example.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.example.entity.Event;
import org.example.exception.EventNotFoundException;
import org.example.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository repository;

    public EventServiceImpl(EventRepository repository) {
        this.repository = repository;
    }

    public Event createEvent(Event event) {
        return repository.save(event);
    }

    public List<Event> getAllEvents() {
        return repository.findAll();
    }

    public Event getEventById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EventNotFoundException("Event not found with id " + id));
    }

    public Event updateEvent(Long id, Event event) {
        Event existing = getEventById(id);
        existing.setName(event.getName());
        existing.setLocation(event.getLocation());
        existing.setDate(event.getDate());
        existing.setOrganizer(event.getOrganizer());
        return repository.save(existing);
    }

    public void deleteEvent(Long id) {
        repository.delete(getEventById(id));
    }
}

