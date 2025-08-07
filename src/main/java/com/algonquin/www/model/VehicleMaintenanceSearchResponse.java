package com.algonquin.www.model;
/**
 * Response model for vehicle maintenance search results with pagination.
 * <p>
 * Extends {@link PageResponse} to include pagination metadata and
 * contains a list of {@link VehicleMaintenanceInfo} objects representing
 * the maintenance records returned by the search.
 * </p>
 */

import java.util.List;

/**
 *
 * @author Sreelakshmi
 */
public class VehicleMaintenanceSearchResponse extends PageResponse {

    List<VehicleMaintenanceInfo> data;
     /**
     * Gets the list of vehicle maintenance records.
     *
     * @return the list of {@link VehicleMaintenanceInfo} objects
     */

    public List<VehicleMaintenanceInfo> getData() {
        return data;
    }
     /**
     * Sets the list of vehicle maintenance records.
     *
     * @param data the list of {@link VehicleMaintenanceInfo} objects
     */
    
    public void setData(List<VehicleMaintenanceInfo> data) {
        this.data = data;
    }
}
