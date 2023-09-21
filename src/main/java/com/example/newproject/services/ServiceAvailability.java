package com.example.newproject.services;

import com.example.newproject.entities.Availability;
import com.example.newproject.repositories.IAvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceAvailability implements IServiceAvailability {
    // Inject the AvailabilityRepository (assuming you have one)
    private final IAvailabilityRepository availabilityRepository;

    @Autowired
    public ServiceAvailability(IAvailabilityRepository availabilityRepository) {
        this.availabilityRepository = availabilityRepository;
    }

    @Override
    public Availability createAvailability(Availability availability) {
        return availabilityRepository.save(availability);
    }

    @Override
    public List<Availability> getAllAvailabilities() {
        return availabilityRepository.findAll();
    }

    @Override
    public Availability getAvailabilityById(Integer id) {
        return availabilityRepository.findById(id).orElse(null);
    }

    @Override
    public Availability updateAvailability(Integer id, Availability updatedAvailability) {
        Availability existingAvailability = availabilityRepository.findById(id).orElse(null);
        if (existingAvailability != null) {
            return availabilityRepository.save(existingAvailability);
        }
        return null;
    }

    @Override
    public void deleteAvailability(Integer id) {
        Availability existingAvailability = availabilityRepository.findById(id).orElse(null);
        if (existingAvailability != null) {
            availabilityRepository.delete(existingAvailability);
        }
    }
}
