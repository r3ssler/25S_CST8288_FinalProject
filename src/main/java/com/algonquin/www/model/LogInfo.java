package com.algonquin.www.model;

/**
 * Model class representing log information for a vehicle.
 * <p>
 * Contains details about the vehicle number, log type, location, and the time of the log.
 * </p>
 */

public class LogInfo {
    private String vehicleNumber;
    private String type;
    private String location;
    private String time;
    
    /**
     * Gets the vehicle number associated with this log.
     *
     * @return the vehicle number
     */

    public String getVehicleNumber() {
        return vehicleNumber;
    }
    
    /**
     * Sets the vehicle number associated with this log.
     *
     * @param vehicleNumber the vehicle number
     */

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    
    /**
     * Gets the type of the log.
     * <p>
     * Examples might include "maintenance", "location update", or "incident".
     * </p>
     *
     * @return the log type
     */

    public String getType() {
        return type;
    }
    
     /**
     * Sets the type of the log.
     *
     * @param type the log type
     */

    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * Gets the location related to this log entry.
     *
     * @return the location
     */

    public String getLocation() {
        return location;
    }
     /**
     * Sets the location related to this log entry.
     *
     * @param location the location
     */

    public void setLocation(String location) {
        this.location = location;
    }
    
     /**
     * Gets the time when this log entry was recorded.
     * <p>
     * The time is represented as a String, typically formatted as ISO 8601 or
     * another agreed format.
     * </p>
     *
     * @return the log time
     */

    public String getTime() {
        return time;
    }
    /**
     * Sets the time when this log entry was recorded.
     *
     * @param time the log time
     */

    public void setTime(String time) {
        this.time = time;
    }
}
