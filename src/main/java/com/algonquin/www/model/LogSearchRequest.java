package com.algonquin.www.model;
/**
 * Request model for searching vehicle logs with pagination support.
 * <p>
 * Extends {@link PageRequest} to include pagination parameters and
 * adds filters for vehicle number and log type.
 * </p>
 */

public class LogSearchRequest extends PageRequest {
    private String vehicleNumber;
    private String type;
    
    /**
     * Gets the vehicle number filter for the log search.
     *
     * @return the vehicle number filter, or null if not set
     */

    public String getVehicleNumber() {
        return vehicleNumber;
    }
    /**
     * Sets the vehicle number filter for the log search.
     *
     * @param vehicleNumber the vehicle number filter
     */

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
     /**
     * Gets the log type filter for the search.
     *
     * @return the log type filter, or null if not set
     */

    public String getType() {
        return type;
    }
     /**
     * Sets the log type filter for the search.
     *
     * @param type the log type filter
     */

    public void setType(String type) {
        this.type = type;
    }
}
