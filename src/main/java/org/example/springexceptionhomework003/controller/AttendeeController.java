package org.example.springexceptionhomework003.controller;

import jakarta.validation.Valid;
import org.example.springexceptionhomework003.exception.NotFoundException;
import org.example.springexceptionhomework003.model.dto.request.AttendeeRequest;
import org.example.springexceptionhomework003.model.dto.respone.ApiRespone;
import org.example.springexceptionhomework003.model.entity.Attendee;
import org.example.springexceptionhomework003.service.AttendeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/venues")
public class AttendeeController {
    private final AttendeeService attendeeService;

    public AttendeeController(AttendeeService attendeeService) {
        this.attendeeService = attendeeService;
    }

    @GetMapping
    public ResponseEntity<ApiRespone<List<Attendee>>> getAttendee() {
        ApiRespone<List<Attendee>> response = ApiRespone.<List<Attendee>>builder()
                .message("Get attendee successful")
                .status(HttpStatus.OK)
                .success(true)
                .payload(attendeeService.getAttendee())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
    @GetMapping("{attendee-id}")
    public ResponseEntity<ApiRespone<Attendee>> getAttendeebyId(@PathVariable("attendee-id") Integer attendeeId) {
        Attendee attendee = attendeeService.getAttendeebyId(attendeeId);
        if(attendee==null){
            throw new NotFoundException("Attendee Id : " + attendeeId + " Not Found !");
        }
        ApiRespone <Attendee> response = ApiRespone.<Attendee>builder()
                .message("Get attendee by id successful")
                .status(HttpStatus.OK)
                .success(true)
                .payload(attendeeService.getAttendeebyId(attendeeId))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<ApiRespone<Attendee>> addAttendee(@Valid @RequestBody AttendeeRequest attendeeRequest) {
        ApiRespone <Attendee> response = ApiRespone.<Attendee>builder()
                .message("add attendee successful")
                .status(HttpStatus.OK)
                .success(true)
                .payload(attendeeService.addAttendee(attendeeRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("{attendee-id}")
    public ResponseEntity<ApiRespone<Attendee>> updateAttendee(@PathVariable("attendee-id") Integer attendeeId , @Valid @RequestBody AttendeeRequest attendeeRequest) {
        Attendee attendee = attendeeService.getAttendeebyId(attendeeId);
        if(attendee==null){
            throw new NotFoundException("Attendee Id : " + attendeeId + " Not Found !");
        }
        ApiRespone <Attendee> response = ApiRespone.<Attendee>builder()
                .message("update attendee successful")
                .status(HttpStatus.OK)
                .success(true)
                .payload(attendeeService.updateAttendee(attendeeId,attendeeRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("{attendee-id}")
    public ResponseEntity<?> deleteAttendee(@PathVariable("attendee-id") Integer attendeeId) {
        Attendee attendee = attendeeService.getAttendeebyId(attendeeId);
        if(attendee==null){
            throw new NotFoundException("Attendee Id : " + attendeeId + " Not Found !");
        }
        attendeeService.deleteAttendee(attendeeId);
        ApiRespone <String> response = ApiRespone.<String>builder()
                .message("Delete attendee successful")
                .status(HttpStatus.OK)
                .success(true)
                .payload("suceess")
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
}
