package com.algonquin.www.model;

import java.util.List;
/**
 * Response model for vehicle search results with pagination.
 * <p>
 * Extends {@link PageResponse} to include pagination metadata and
 * contains a list of {@link VehicleInfo} objects representing the
 * vehicles matching the search criteria.
 * </p>
 */

public class VehicleSearchResponse extends PageResponse {
    
    private List<VehicleInfo> data;
     /**
     * Gets the list of vehicles returned by the search.
     *
     * @return the list of {@link VehicleInfo} objects
     */

    public List<VehicleInfo> getData() {
        return data;
    }/**
     * Sets the list of vehicles returned by the search.
     *
     * @param data the list of {@link VehicleInfo} objects
     */

    public void setData(List<VehicleInfo> data) {
        this.data = data;
    }
}
