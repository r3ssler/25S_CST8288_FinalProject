
package com.algonquin.www.dao;

import com.algonquin.www.domain.VehicleLogDTO;

import java.util.List;
/**
 * Data Access Object (DAO) interface for managing {@link VehicleLogDTO} entities.
 * <p>
 * Provides methods for searching and adding vehicle log entries.
 * </p>
 * 
 * <p>This interface abstracts the data layer access for vehicle logs,
 * enabling different implementations to interact with the underlying storage.</p>
 * 
 * @author
 * @version 1.0
 * @since 2025-08-07
 */

public interface VehicleLogDAO {
    /**
     * Searches for vehicle log entries matching the specified vehicle number.
     * 
     * @param vehicleNumber the vehicle number to search logs for (can be partial or full)
     * @return a list of {@link VehicleLogDTO} objects associated with the vehicle
     */
    
    List<VehicleLogDTO> search(String vehicleNumber);
     /**
     * Adds a new vehicle log entry to the data store.
     * 
     * @param log the {@link VehicleLogDTO} object representing the log entry to add
     * @return true if the log was successfully added, false otherwise
     */
     
    boolean addLog(VehicleLogDTO log);
}
