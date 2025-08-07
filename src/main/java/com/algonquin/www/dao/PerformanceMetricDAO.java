package com.algonquin.www.dao;

import com.algonquin.www.domain.PerformanceMetricDTO;
import java.util.List;

/**
 * Data Access Object (DAO) interface for managing {@link PerformanceMetricDTO} entities.
 * <p>
 * Provides methods to retrieve, add, and update performance metrics related to users.
 * </p>
 * 
 * <p>This interface abstracts the underlying data storage mechanism for performance metrics,
 * allowing implementations to interact with databases or other data sources.</p>
 * 
 * @author
 * @version 1.0
 * @since 2025-08-07
 */

public interface PerformanceMetricDAO {
     /**
     * Retrieves all performance metrics.
     * 
     * @return a list of all {@link PerformanceMetricDTO} objects
     */
    
    List<PerformanceMetricDTO> selectAll();
     /**
     * Retrieves the performance metric associated with the specified username.
     * 
     * @param userName the username to search by
     * @return the {@link PerformanceMetricDTO} matching the username, or null if none found
     */
    
    PerformanceMetricDTO selectByUserName(String userName);
     /**
     * Retrieves the performance metric associated with the specified user ID.
     * 
     * @param userId the user ID to search by
     * @return the {@link PerformanceMetricDTO} matching the user ID, or null if none found
     */
    
    PerformanceMetricDTO getByUserId(Long userId);
    /**
     * Updates an existing performance metric record.
     * 
     * @param dto the {@link PerformanceMetricDTO} object containing updated data
     * @return true if the update was successful, false otherwise
     */
    
    boolean update(PerformanceMetricDTO dto);
     /**
     * Adds a new performance metric record.
     * 
     * @param dto the {@link PerformanceMetricDTO} object to add
     * @return true if the addition was successful, false otherwise
     */

    boolean add(PerformanceMetricDTO dto);
}
