package org.example.springexceptionhomework003.service;

import org.example.springexceptionhomework003.model.entity.Venues;

import java.util.List;

public interface VenuesService {
    List<Venues> getVenues();

    Venues getVenuesbyId(Integer venus_id);
}
