package org.example.springexceptionhomework003.repository;

import org.apache.ibatis.annotations.*;
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
}
