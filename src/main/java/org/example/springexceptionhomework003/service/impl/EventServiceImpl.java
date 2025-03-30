package org.example.springexceptionhomework003.service.impl;

import org.example.springexceptionhomework003.model.dto.request.EventRequest;
import org.example.springexceptionhomework003.model.entity.Event;
import org.example.springexceptionhomework003.repository.EventRepository;
import org.example.springexceptionhomework003.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getEvent() {
        return eventRepository.getEvent();
    }

    @Override
    public Event getEventbyId(Integer eventId) {
        return eventRepository.getEventbyId(eventId);
    }

    @Override
    public Event addEvent(EventRequest eventRequest) {
        return eventRepository.addEvent(eventRequest);
    }
}
