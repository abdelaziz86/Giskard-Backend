package com.example.newproject.controller;

import com.example.newproject.entities.Reservation;
import com.example.newproject.services.IServiceReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
