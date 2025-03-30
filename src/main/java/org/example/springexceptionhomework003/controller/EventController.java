package org.example.springexceptionhomework003.controller;

import org.example.springexceptionhomework003.model.dto.respone.ApiRespone;
import org.example.springexceptionhomework003.model.entity.Attendee;
import org.example.springexceptionhomework003.model.entity.Event;
import org.example.springexceptionhomework003.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
