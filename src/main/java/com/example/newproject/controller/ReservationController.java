package com.example.newproject.controller;

import com.example.newproject.entities.Availability;
import com.example.newproject.entities.Reservation;
import com.example.newproject.services.IServiceReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "http://127.0.0.1:5173")
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final IServiceReservation reservationService;

    @Autowired
    public ReservationController(IServiceReservation reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        Reservation createdReservation = reservationService.createReservation(reservation);
        return new ResponseEntity<>(createdReservation, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable Integer id, @RequestParam String email) {
        reservationService.deleteReservation(id, email);
        return ResponseEntity.ok("Reservation deleted successfully");
    }


    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationService.listReservations();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Integer id) {
        Reservation reservation = reservationService.getReservationById(id);
        if (reservation != null) {
            return new ResponseEntity<>(reservation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
