package com.example.newproject.controller;

import com.example.newproject.entities.Availability;
import com.example.newproject.repositories.IAvailabilityRepository;
import com.example.newproject.services.IServiceAvailability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/availability")
public class AvailabilityController {

    private final IServiceAvailability availabilityService;

    @Autowired
    public AvailabilityController(IServiceAvailability availabilityService) {
        this.availabilityService = availabilityService;
    }

    @PostMapping
    public ResponseEntity<Availability> createAvailability(@RequestBody Availability availability) {
        Availability createdAvailability = availabilityService.createAvailability(availability);
        System.out.println("Start : "+ availability.getStart());
        return new ResponseEntity<>(createdAvailability, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Availability>> getAllAvailabilities() {
        List<Availability> availabilities = availabilityService.getAllAvailabilities();
        return new ResponseEntity<>(availabilities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Availability> getAvailabilityById(@PathVariable Integer id) {
        Availability availability = availabilityService.getAvailabilityById(id);
        if (availability != null) {
            return new ResponseEntity<>(availability, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Availability> updateAvailability(@PathVariable Integer id, @RequestBody Availability updatedAvailability) {
        Availability availability = availabilityService.updateAvailability(id, updatedAvailability);
        if (availability != null) {
            return new ResponseEntity<>(availability, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAvailability(@PathVariable Integer id) {
        availabilityService.deleteAvailability(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
