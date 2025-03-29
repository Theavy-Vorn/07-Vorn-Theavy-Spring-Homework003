package org.example.springexceptionhomework003.service;

import jakarta.validation.Valid;
import org.example.springexceptionhomework003.model.dto.request.AttendeeRequest;
import org.example.springexceptionhomework003.model.entity.Attendee;

import java.util.List;

public interface AttendeeService {
    List <Attendee> getAttendee();


    Attendee getAttendeebyId(Integer attendeeId);

    Attendee updateAttendee(Integer attendeeId, AttendeeRequest attendeeRequest);


    Attendee addAttendee(@Valid AttendeeRequest attendeeRequest);

    void deleteAttendee(Integer attendeeId);
}
