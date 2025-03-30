package org.example.springexceptionhomework003.service;

import jakarta.validation.Valid;
import org.example.springexceptionhomework003.model.dto.request.EventRequest;
import org.example.springexceptionhomework003.model.entity.Event;

import java.util.List;

public interface EventService {
    List<Event> getEvent();

    Event getEventbyId(Integer eventId);

    Event addEvent(@Valid EventRequest eventRequest);
}
