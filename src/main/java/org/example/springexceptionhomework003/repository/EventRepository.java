package org.example.springexceptionhomework003.repository;

import org.apache.ibatis.annotations.*;
import org.example.springexceptionhomework003.model.entity.Event;
import org.example.springexceptionhomework003.model.entity.Venues;
import org.example.springexceptionhomework003.model.entity.Attendee;

import java.util.List;

@Mapper
public interface EventRepository {

    @Select("""
        SELECT * FROM events;
    """)
    @Results(id="EventMapper", value={
            @Result(property = "eventId", column = "event_id"),
            @Result(property = "eventName", column = "event_name"),
            @Result(property = "eventDate", column = "event_date"),
            @Result(property = "venue", column = "venue_id",
                    one = @One(select = "org.example.springexceptionhomework003.repository.VenuesRepository.getVenuesbyId")),
            @Result(property = "attendee",
                    column = "event_id",
                    many = @Many(select = "org.example.springexceptionhomework003.repository.EventAttendeeRepository.getAttendeesByEventId"))

    })
    List<Event> getEvent();
}
