package com.example.newproject.services;

import com.example.newproject.entities.Availability;
import com.example.newproject.entities.Reservation;

import java.util.List;

public interface IServiceReservation {
    Reservation createReservation(Reservation reservation);
    void deleteReservation(Integer id, String email);
    List<Reservation> listReservations();

    Reservation getReservationById(Integer id);
}
