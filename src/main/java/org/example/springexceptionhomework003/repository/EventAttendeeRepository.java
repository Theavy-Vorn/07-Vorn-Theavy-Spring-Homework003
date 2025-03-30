package org.example.springexceptionhomework003.repository;

import org.apache.ibatis.annotations.*;
import org.example.springexceptionhomework003.model.entity.Attendee;
import java.util.List;

@Mapper
public interface EventAttendeeRepository {

    @Select("""
    SELECT a.attendee_id, a.attendee_name, a.email
    FROM attendee a 
    INNER JOIN event_attendee ea ON a.attendee_id = ea.attendee_id
    WHERE ea.event_id = #{eventId}
""")
    @Results(id="AttendeeMapper", value = {
            @Result(property="attendeeId", column="attendee_id"),
            @Result(property="attendeeName", column="attendee_name"),
            @Result(property="email", column="email")
    })
    List<Attendee> getAttendeesByEventId(@Param("eventId") Integer eventId);

}
