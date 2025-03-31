package org.example.springexceptionhomework003.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springexceptionhomework003.model.entity.Attendee;
import org.example.springexceptionhomework003.model.entity.Venues;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {
    private String eventName;
    private LocalDate eventDate;
    private Integer venuesId;
    private List<Integer> attendeesId;
}
