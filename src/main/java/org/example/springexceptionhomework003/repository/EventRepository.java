package org.example.springexceptionhomework003.repository;

import org.apache.ibatis.annotations.*;
import org.example.springexceptionhomework003.model.dto.request.EventRequest;
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

    @Select("""
       SELECT * FROM events WHERE event_id =#{evenId};
    """)

    @ResultMap("EventMapper")
    Event getEventbyId(Integer eventId);

    @Select("""
       INSERT INTO events(event_name,event_date,venue_id)
       VALUES (#{request.eventName},#{request.eventDate},#{request.venuesId})
       returning *
    """)
    @ResultMap("EventMapper")
    Event addEvent(@Param("request") EventRequest eventRequest);

    @Insert("""
        INSERT INTO event_attendee(event_id,attendee_id)
        VALUES (#{eventId},#{idAt});
    """)
    void addEventAttendee(Integer idAt, Integer eventId);

    @Select("""
        UPDATE events SET event_name=#{eventName},event_date=#{eventDate},venue_id=#{venuesId}
        WHERE event_id = #{eventId};
    """)
    @ResultMap("EventMapper")
    Event updateEvent(Integer eventId, EventRequest eventRequest);

}
