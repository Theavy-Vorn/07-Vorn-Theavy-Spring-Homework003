package org.example.springexceptionhomework003.controller;

import jakarta.validation.Valid;
import org.example.springexceptionhomework003.exception.NotFoundException;
import org.example.springexceptionhomework003.model.dto.request.EventRequest;
import org.example.springexceptionhomework003.model.dto.respone.ApiRespone;
import org.example.springexceptionhomework003.model.entity.Attendee;
import org.example.springexceptionhomework003.model.entity.Event;
import org.example.springexceptionhomework003.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<ApiRespone<List<Event>>> getEvent() {
        ApiRespone<List<Event>> response = ApiRespone.<List<Event>>builder()
            .message("Get event successful")
            .status(HttpStatus.OK)
            .success(true)
            .payload(eventService.getEvent())
            .timestamp(LocalDateTime.now())
            .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("{event-id}")
    public ResponseEntity<ApiRespone<Event>> getEventbyId(@PathVariable("event-id") Integer eventId) {
        Event event = eventService. getEventbyId(eventId);
        if(event==null){
            throw new NotFoundException("Attendee Id : " + eventId + " Not Found !");
        }
        ApiRespone<Event> response = ApiRespone.<Event>builder()
                .message("Get event by id successful")
                .status(HttpStatus.OK)
                .success(true)
                .payload(eventService.getEventbyId(eventId))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiRespone<Event>> addEvent(@Valid @RequestBody EventRequest eventRequest) {
        ApiRespone<Event> response = ApiRespone.<Event>builder()
                .message("Get event by id successful")
                .status(HttpStatus.OK)
                .success(true)
                .payload(eventService.addEvent(eventRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
}
