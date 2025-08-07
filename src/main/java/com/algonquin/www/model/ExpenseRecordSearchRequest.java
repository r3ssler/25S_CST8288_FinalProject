package com.algonquin.www.model;
/**
 * Request model for searching expense records with pagination support.
 * <p>
 * Extends {@link PageRequest} to include pagination parameters and
 * adds a filter for the vehicle number.
 * </p>
 */

public class ExpenseRecordSearchRequest extends PageRequest {
    private String vehicleNumber;
    
     /**
     * Gets the vehicle number filter for the search.
     *
     * @return the vehicle number, or null if no filter applied
     */

    public String getVehicleNumber() {
        return vehicleNumber;
    }
    
     /**
     * Sets the vehicle number filter for the search.
     *
     * @param vehicleNumber the vehicle number to filter by
     */

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
}
