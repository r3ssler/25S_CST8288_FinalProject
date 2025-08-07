package com.algonquin.www.model;
/**
 * Request model for searching vehicles with pagination support.
 * <p>
 * Extends {@link PageRequest} to include pagination parameters and
 * provides a filter by vehicle number.
 * </p>
 */

public class VehicleSearchRequest extends PageRequest {

    private String vehicleNumber;
     /**
     * Gets the vehicle number filter for the search.
     *
     * @return the vehicle number
     */

    public String getVehicleNumber() {
        return vehicleNumber;
    }
     /**
     * Sets the vehicle number filter for the search.
     *
     * @param vehicleNumber the vehicle number
     */
    
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
}
