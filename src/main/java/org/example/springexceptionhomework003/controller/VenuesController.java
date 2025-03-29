package org.example.springexceptionhomework003.controller;

import jakarta.validation.Valid;
import org.example.springexceptionhomework003.exception.NotFoundException;
import org.example.springexceptionhomework003.model.dto.request.VenuesRequest;
import org.example.springexceptionhomework003.model.dto.respone.ApiRespone;
import org.example.springexceptionhomework003.model.entity.Venues;
import org.example.springexceptionhomework003.service.VenuesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        Venues venues = venuesService.getVenuesbyId(venue_id);
        if (venues == null) {
            throw new NotFoundException("Venue ID: " + venue_id + " Not Found!");
        }
        ApiRespone<Venues> response = ApiRespone.<Venues>builder()
                .message("Get venue successful")
                .status(HttpStatus.OK)
                .success(true)
                .payload(venues)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.ok(response);
    }


    @PostMapping
    public ResponseEntity<ApiRespone<Venues>> addVenues(@Valid @RequestBody VenuesRequest venuesRequest){

        ApiRespone<Venues> response = ApiRespone.<Venues>builder()
                .message("add venue successful")
                .status(HttpStatus.OK)
                .success(true)
                .payload(venuesService.addVenues(venuesRequest))
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.ok(response);

    }
    @PutMapping("{venue-id}")
    public ResponseEntity<ApiRespone<Venues>> updateVenues(@PathVariable("venue-id") Integer id, @Valid @RequestBody VenuesRequest venuesRequest){
        Venues venues = venuesService.getVenuesbyId(id);
        if (venues == null) {
            throw new NotFoundException("Venue ID: " + id + " Not Found!");
        }
        ApiRespone<Venues> response = ApiRespone.<Venues>builder()
                .message("update venue successful")
                .status(HttpStatus.OK)
                .success(true)
                .payload(venuesService.updateVenues(id,venuesRequest))
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.ok(response);

    }

    @DeleteMapping("{venue-id}")
    public ResponseEntity<?> deleteVenuesbyId(@PathVariable("venue-id") Integer id) {

        Venues venues = venuesService.getVenuesbyId(id);
        if (venues == null) {
            throw new NotFoundException("Venue ID: " + id + " Not Found!");
        }
        venuesService.deleteVenuesbyId(id);
        ApiRespone<String> response = ApiRespone.<String>builder()
                .message("Delete venue successful")
                .status(HttpStatus.OK)
                .success(true)
                .payload("success")
                .build();

        return ResponseEntity.ok(response);
    }
}
