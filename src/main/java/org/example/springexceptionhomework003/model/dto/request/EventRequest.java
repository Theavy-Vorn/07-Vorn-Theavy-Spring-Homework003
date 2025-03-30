package org.example.springexceptionhomework003.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springexceptionhomework003.model.entity.Attendee;
import org.example.springexceptionhomework003.model.entity.Venues;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {
    private String eventName;
    private LocalDate eventDate;
    private Venues venues;
    private Attendee attendee;
}
