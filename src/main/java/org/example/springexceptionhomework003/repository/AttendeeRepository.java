package org.example.springexceptionhomework003.repository;

import org.apache.ibatis.annotations.*;
import org.example.springexceptionhomework003.model.dto.request.AttendeeRequest;
import org.example.springexceptionhomework003.model.entity.Attendee;

import java.util.List;

@Mapper
public interface AttendeeRepository {

    @Select("""
        SELECT * FROM attendee;
    """)
    @Results(id = "AttendeeMapper", value = {
            @Result(property = "attendeeId", column = "attendee_id"),
            @Result(property = "attendeeName", column = "attendee_name")
    })
    List<Attendee> getAttendee();

    @Select("""
        SELECT * FROM attendee WHERE attendee_id = #{attendeeId};
    """)
    @ResultMap("AttendeeMapper")
    Attendee getAttendeebyId(Integer attendeeId);

    @Select("""
        UPDATE attendee
        SET attendee_name = #{request.attendeeName}, email = #{request.email}
        WHERE attendee_id = #{id}
        RETURNING *;
    """)
    @ResultMap("AttendeeMapper")
    Attendee updateAttendee(@Param("id") Integer attendeeId, @Param("request") AttendeeRequest attendeeRequest);

    @Select("""
        INSERT INTO attendee (attendee_name, email)
        VALUES (#{request.attendeeName}, #{request.email})
        RETURNING *;
    """)
    @ResultMap("AttendeeMapper")
    Attendee addAttendee(@Param("request") AttendeeRequest attendeeRequest);

    @Delete("""
        DELETE FROM attendee WHERE attendee_id=#{attendeeId};
    """)
    void deleteAttendee(Integer attendeeId);
}
