package org.example.springexceptionhomework003.repository;

import jakarta.validation.Valid;
import org.apache.ibatis.annotations.*;
import org.example.springexceptionhomework003.model.dto.request.VenuesRequest;
import org.example.springexceptionhomework003.model.entity.Venues;

import java.util.List;
@Mapper
public interface VenuesRepository {
    @Select("""
        SELECT * FROM venues;    
    """)
    @Results(id="MapperVenes", value = {
            @Result(property = "id",column = "venue_id"),
            @Result(property = "venuesName",column = "venue_name")
    })
    List<Venues> getVenues();
    @Select("""
        SELECT * FROM venues WHERE venue_id =#{venus_id};
    """)
    @ResultMap("MapperVenes")

    Venues getVenuesbyId(Integer venus_id);
    @Select("""
        INSERT INTO venues (venue_name,location) VALUES (#{venuesName},#{location})
        RETURNING *
    """)
    @ResultMap("MapperVenes")
    Venues addVenues(VenuesRequest venuesRequest);
  @Select("""
        UPDATE venues
        SET venue_name=#{request.venuesName}, location=#{request.location}
        WHERE venue_id=#{id}
        RETURNING *;
    """)
    @ResultMap("MapperVenes")
    Venues updateVenues(@Param("id") Integer id, @Param("request") @Valid VenuesRequest venuesRequest);
    @Delete("""
        DELETE FROM venues WHERE venue_id = #{id};
    """)
    @ResultMap("MapperVenes")
    void deleteVenuesbyId(Integer id);
}
