package com.algonquin.www.model;

/**
 * Request model for uploading a vehicle log event.
 * <p>
 * Contains the vehicle number, the type of event, and the location where the event occurred.
 * </p>
 */

public class LogUploadRequest {
    private String vehicleNumber;
    private String eventType;
    private String location;
     /**
     * Gets the vehicle number associated with this log event.
     *
     * @return the vehicle number
     */

    public String getVehicleNumber() {
        return vehicleNumber;
    }
    
    /**
     * Sets the vehicle number associated with this log event.
     *
     * @param vehicleNumber the vehicle number
     */

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    
     /**
     * Gets the event type of the log.
     * <p>
     * For example: "maintenance", "incident", "location update".
     * </p>
     *
     * @return the event type
     */

    public String getEventType() {
        return eventType;
    }
    
    /**
     * Sets the event type of the log.
     *
     * @param eventType the event type
     */

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
    
    /**
     * Gets the location where the event occurred.
     *
     * @return the location description
     */

    public String getLocation() {
        return location;
    }
     /**
     * Sets the location where the event occurred.
     *
     * @param location the location description
     */

    public void setLocation(String location) {
        this.location = location;
    }
}
