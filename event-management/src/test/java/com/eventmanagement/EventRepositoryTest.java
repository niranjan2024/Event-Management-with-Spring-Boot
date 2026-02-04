package com.eventmanagement;

import com.eventmanagement.entity.Event;
import com.eventmanagement.repository.EventRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class EventRepositoryTest {

    @Autowired
    private EventRepository eventRepository;

    @Test
    void saveEvent_shouldPersistData() {
        Event event = new Event();
        event.setName("Conference");

        Event saved = eventRepository.save(event);

        assertNotNull(saved.getId());
    }
}
