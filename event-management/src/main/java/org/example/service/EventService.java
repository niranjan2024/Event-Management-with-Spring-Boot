package org.example.service;

import java.util.List;
import org.example.entity.Event;

public interface EventService {

    Event createEvent(Event event);
    List<Event> getAllEvents();
    Event getEventById(Long id);
    Event updateEvent(Long id, Event event);
    void deleteEvent(Long id);
}

