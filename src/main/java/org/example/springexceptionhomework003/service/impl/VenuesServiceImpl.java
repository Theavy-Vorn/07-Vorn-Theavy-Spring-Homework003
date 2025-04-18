package org.example.springexceptionhomework003.service.impl;

import org.example.springexceptionhomework003.model.dto.request.VenuesRequest;
import org.example.springexceptionhomework003.model.entity.Venues;
import org.example.springexceptionhomework003.repository.VenuesRepository;
import org.example.springexceptionhomework003.service.VenuesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenuesServiceImpl implements VenuesService {
    private final VenuesRepository venuesRepository;

    public VenuesServiceImpl(VenuesRepository venuesRepository) {
        this.venuesRepository = venuesRepository;
    }

    @Override
    public List<Venues> getVenues() {
        return venuesRepository.getVenues();
    }

    @Override
    public Venues getVenuesbyId(Integer venus_id) {
        return venuesRepository.getVenuesbyId(venus_id);
    }

    @Override
    public Venues addVenues(VenuesRequest venuesRequest) {
        return venuesRepository.addVenues(venuesRequest);
    }

    @Override
    public Venues updateVenues(Integer id, VenuesRequest venuesRequest) {
        return venuesRepository.updateVenues(id,venuesRequest);
    }

    @Override
    public void deleteVenuesbyId(Integer id) {
        venuesRepository.deleteVenuesbyId(id);
    }


}
