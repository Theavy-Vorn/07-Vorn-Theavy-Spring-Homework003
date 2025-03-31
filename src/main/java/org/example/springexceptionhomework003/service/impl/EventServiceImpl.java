package org.example.springexceptionhomework003.service.impl;

import org.example.springexceptionhomework003.model.dto.request.EventRequest;
import org.example.springexceptionhomework003.model.entity.Event;
import org.example.springexceptionhomework003.repository.EventRepository;
import org.example.springexceptionhomework003.service.EventService;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
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
    //data store in eventRequest
    @Override
    public Event addEvent(EventRequest eventRequest) {
        //for input value in eventAttentee for loop id of attendee
        //store value input in event

        System.out.println(eventRequest);

        Event event = eventRepository.addEvent(eventRequest);
         for (Integer idAt : eventRequest.getAttendeesId()){
             eventRepository.addEventAttendee(idAt,event.getEventId());
         }
        return eventRepository.addEvent(eventRequest);
    }

    @Override
    public Event updateEvent(Integer eventId, EventRequest eventRequest) {
        Event event = eventRepository.updateEvent( eventId,eventRequest);
        for (Integer idAt : eventRequest.getAttendeesId()){
//            eventRepository.updateEventAttendee(idAt,event.getEventId());
        }
        return eventRepository.updateEvent(eventId,eventRequest);
    }
}
