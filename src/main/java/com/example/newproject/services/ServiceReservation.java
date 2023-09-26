package com.example.newproject.services;

import com.example.newproject.entities.Reservation;
import com.example.newproject.repositories.IReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceReservation implements IServiceReservation {
    @Autowired
    private final IReservationRepository reservationRepository;

    @Autowired
    public ServiceReservation(IReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        // Implement the logic to create a reservation and save it to the repository
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(Integer id, String email) {
        // Implement the logic to delete a reservation by ID and validate the provided email
        Optional<Reservation> existingReservation = reservationRepository.findById(id);
        if (existingReservation.isPresent()) {
            Reservation reservation = existingReservation.get();
            if (email.equals(reservation.getEmail())) {
                reservationRepository.delete(reservation);
            } else {
                // Handle invalid email (throw an exception or return an error response)
                throw new IllegalArgumentException("Invalid email for this reservation");
            }
        } else {
            // Handle reservation not found (throw an exception or return an error response)
            throw new IllegalArgumentException("Reservation not found with ID: " + id);
        }
    }

    @Override
    public List<Reservation> listReservations() {
        // Implement the logic to retrieve and return a list of all reservations
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(Integer id) {
        return reservationRepository.findById(id).orElse(null);
    }
}
