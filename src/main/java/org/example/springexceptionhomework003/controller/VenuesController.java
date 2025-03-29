package org.example.springexceptionhomework003.controller;

import org.example.springexceptionhomework003.exception.NotFondException;
import org.example.springexceptionhomework003.model.dto.respone.ApiRespone;
import org.example.springexceptionhomework003.model.entity.Venues;
import org.example.springexceptionhomework003.service.VenuesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("a1/v1/venues")
public class VenuesController {
    private final VenuesService venuesService;

    public VenuesController(VenuesService venuesService) {
        this.venuesService = venuesService;
    }

    @GetMapping
    public ResponseEntity<ApiRespone<List<Venues>>> getVenues() {
        ApiRespone<List<Venues>> response = ApiRespone.<List<Venues>>builder()
                .message("Get venues successful")
                .status(HttpStatus.OK)
                .success(true)
                .payload(venuesService.getVenues())
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{venue_id}")
    public ResponseEntity<ApiRespone<Venues>> getVenuesbyId(@PathVariable Integer venue_id) {
        try {
            Venues venues = venuesService.getVenuesbyId(venue_id);

            if (venues == null) {
                throw new NotFondException("Venue ID: " + venue_id + " Not Found!");
            }

            ApiRespone<Venues> response = ApiRespone.<Venues>builder()
                    .message("Get venue successful")
                    .status(HttpStatus.OK)
                    .success(true)
                    .payload(venues)
                    .timestamp(LocalDateTime.now())
                    .build();

            return ResponseEntity.ok(response);

        } catch (NotFondException e) {
            ApiRespone<Venues> errorResponse = ApiRespone.<Venues>builder()
                    .message(e.getMessage())
                    .status(HttpStatus.NOT_FOUND)
                    .success(false)
                    .payload(null)
                    .timestamp(LocalDateTime.now())
                    .build();

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }
}
