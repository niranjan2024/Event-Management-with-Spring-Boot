package com.eventmanagement;

import com.eventmanagement.entity.Event;
import com.eventmanagement.repository.EventRepository;
import com.eventmanagement.service.EventService;
import com.eventmanagement.service.EventServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EventServiceTest {

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private EventServiceImpl eventService;

    @Test
    void createEvent_shouldReturnSavedEvent() {
        Event event = new Event();
        event.setName("Workshop");

        when(eventRepository.save(any(Event.class)))
                .thenReturn(event);

        Event result = eventService.createEvent(event);

        assertEquals("Workshop", result.getName());
        verify(eventRepository).save(event);
    }
}
