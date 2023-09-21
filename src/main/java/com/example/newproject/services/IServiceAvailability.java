package com.example.newproject.services;


import com.example.newproject.entities.Availability;

import java.util.List;

public interface IServiceAvailability {
    // Create operation: Create a new availability slot
    Availability createAvailability(Availability availability);

    // Read operation: Get all available slots
    List<Availability> getAllAvailabilities();

    // Read operation: Get an availability slot by ID
    Availability getAvailabilityById(Integer id);

    // Update operation: Update an existing availability slot
    Availability updateAvailability(Integer id, Availability updatedAvailability);

    // Delete operation: Delete an availability slot by ID
    void deleteAvailability(Integer id);
}
