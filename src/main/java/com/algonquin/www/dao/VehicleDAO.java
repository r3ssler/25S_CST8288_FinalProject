package com.algonquin.www.dao;

import com.algonquin.www.domain.VehicleDTO;

import java.util.List;

/**
 * Data Access Object (DAO) interface for managing {@link VehicleDTO} entities.
 * <p>
 * Defines methods for performing CRUD operations and searches on vehicle data.
 * </p>
 * 
 * <p>This interface abstracts the data access layer for vehicles, enabling
 * various implementations for interacting with persistent storage.</p>
 * 
 * @author
 * @version 1.0
 * @since 2025-08-07
 */

public interface VehicleDAO {
    /**
     * Adds a new vehicle to the data store.
     *
     * @param vehicle the {@link VehicleDTO} object representing the vehicle to add
     * @return true if the vehicle was successfully added, false otherwise
     */
    
    boolean addVehicle(VehicleDTO vehicle);
    /**
     * Searches for vehicles matching the given vehicle number.
     * 
     * @param vehicleNumber the vehicle number to search for (can be partial or full)
     * @return a list of {@link VehicleDTO} objects matching the search criteria
     */
     
    List<VehicleDTO> search(String vehicleNumber);
     /**
     * Retrieves all vehicles from the data store.
     *
     * @return a list of all {@link VehicleDTO} objects
     */
    
    List<VehicleDTO> searchAll();
    /**
     * Searches for vehicles with the exact vehicle number.
     * 
     * @param vehicleNumber the exact vehicle number to search for
     * @return a list of {@link VehicleDTO} objects matching the exact vehicle number
     */

    List<VehicleDTO> searchByVehicleNumber(String vehicleNumber);
    /**
     * Updates the information of an existing vehicle in the data store.
     *
     * @param vehicle the {@link VehicleDTO} object containing updated vehicle data
     * @return true if the update was successful, false otherwise
     */
    
    boolean updateVehicle(VehicleDTO vehicle);
}
