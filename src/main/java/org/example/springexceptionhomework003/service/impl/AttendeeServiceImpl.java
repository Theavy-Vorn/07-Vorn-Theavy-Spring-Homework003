package org.example.springexceptionhomework003.service.impl;

import org.example.springexceptionhomework003.model.dto.request.AttendeeRequest;
import org.example.springexceptionhomework003.model.entity.Attendee;
import org.example.springexceptionhomework003.repository.AttendeeRepository;
import org.example.springexceptionhomework003.service.AttendeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendeeServiceImpl implements AttendeeService {
    private final AttendeeRepository attendeeRepository;

    // ✅ Correct constructor without circular dependency
    public AttendeeServiceImpl(AttendeeRepository attendeeRepository) {
        this.attendeeRepository = attendeeRepository;
    }

    @Override
    public List<Attendee> getAttendee() {
        return attendeeRepository.getAttendee();
    }

    @Override
    public Attendee getAttendeebyId(Integer attendeeId) {
        return attendeeRepository.getAttendeebyId(attendeeId);
    }

    @Override
    public Attendee updateAttendee(Integer attendeeId, AttendeeRequest attendeeRequest) {
        return attendeeRepository.updateAttendee(attendeeId, attendeeRequest);
    }

    @Override
    public Attendee addAttendee(AttendeeRequest attendeeRequest) {
        return attendeeRepository.addAttendee(attendeeRequest);
    }

    @Override
    public void deleteAttendee(Integer attendeeId) {
        attendeeRepository.deleteAttendee(attendeeId);
    }
}
