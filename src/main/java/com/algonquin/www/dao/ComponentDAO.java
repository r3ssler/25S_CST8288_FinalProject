package com.algonquin.www.dao;

import com.algonquin.www.domain.ComponentDTO;

import java.util.List;

/**
 * Data Access Object (DAO) interface for managing ComponentDTO entities.
 * <p>
 * Defines the contract for CRUD operations related to vehicle components,
 * such as adding multiple components, retrieving components by vehicle number,
 * and updating individual components.
 * </p>
 * 
 * @author
 * @version 1.0
 * @since 2025-08-07
 */

public interface ComponentDAO {
    
    /**
     * Adds a list of components to the data store.
     *
     * @param components the list of components to add
     * @return {@code true} if the components were successfully added; {@code false} otherwise
     */
    
    boolean addComponents(List<ComponentDTO> components);
    
     /**
     * Finds and returns a list of components associated with a specific vehicle.
     *
     * @param vehicleNumber the unique identifier of the vehicle
     * @return a list of components belonging to the vehicle, or an empty list if none found
     */
    
    List<ComponentDTO> findByVehicle(String vehicleNumber);
    
    /**
     * Updates an existing component in the data store.
     *
     * @param componentDTO the component to update
     * @return {@code true} if the update was successful; {@code false} otherwise
     */
    
    boolean updateComponent(ComponentDTO componentDTO);
}
