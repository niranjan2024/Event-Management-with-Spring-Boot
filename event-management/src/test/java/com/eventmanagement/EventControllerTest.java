package com.eventmanagement;

import com.eventmanagement.controller.EventController;
import com.eventmanagement.entity.Event;
import com.eventmanagement.service.EventService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EventController.class)
class EventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventService eventService;

    @Test
    void createEvent_shouldReturnOk() throws Exception {

        Event mockEvent = new Event();
        mockEvent.setName("Workshop");

        when(eventService.createEvent(any(Event.class)))
                .thenReturn(mockEvent);

        mockMvc.perform(post("/api/events")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Workshop\"}"))
                .andExpect(status().isOk());
    }
}
