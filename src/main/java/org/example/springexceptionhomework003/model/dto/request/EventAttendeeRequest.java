package org.example.springexceptionhomework003.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springexceptionhomework003.model.entity.Attendee;
import org.example.springexceptionhomework003.model.entity.Event;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventAttendeeRequest {
    private Event event;
    private Attendee attendee;
}
