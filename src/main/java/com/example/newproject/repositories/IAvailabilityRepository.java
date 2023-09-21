package com.example.newproject.repositories;

import com.example.newproject.entities.Availability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAvailabilityRepository extends JpaRepository<Availability,Integer> {
}
