package org.example.springexceptionhomework003.service;

import jakarta.validation.Valid;
import org.example.springexceptionhomework003.model.dto.request.VenuesRequest;
import org.example.springexceptionhomework003.model.entity.Venues;

import java.util.List;

public interface VenuesService {

    List<Venues> getVenues();
    Venues getVenuesbyId(Integer venus_id);
    Venues addVenues(VenuesRequest venuesRequest) ;

    Venues updateVenues(Integer id, @Valid VenuesRequest venuesRequest);

    void deleteVenuesbyId(Integer id);
}
