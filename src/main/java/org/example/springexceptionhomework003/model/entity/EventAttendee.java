package org.example.springexceptionhomework003.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventAttendee {
    private Integer id;
    private Event event;
    private List<Attendee> attendee;;

}
