package com.algonquin.www.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Data Transfer Object (DTO) representing a vehicle log entry.
 * <p>
 * Contains details about events or status updates for a vehicle, including the type of log,
 * location, and the timestamp when the log was recorded.
 * </p>
 */

public class VehicleLogDTO implements Serializable {
    private Long id;
    private String vehicleNumber;
    private String logType;
    private String location;
    private LocalDateTime logTime;
    
    /**
     * Gets the unique identifier of this vehicle log.
     *
     * @return the log's id
     */

    public Long getId() {
        return id;
    }
    
     /**
     * Sets the unique identifier of this vehicle log.
     *
     * @param id the log's id
     */

    public void setId(Long id) {
        this.id = id;
    }
    
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
     * Gets the type/category of this log entry.
     * <p>
     * Examples could include "maintenance", "location update", "incident", etc.
     * </p>
     *
     * @return the log type
     */

    public String getLogType() {
        return logType;
    }
    
     /**
     * Sets the type/category of this log entry.
     *
     * @param logType the log type
     */

    public void setLogType(String logType) {
        this.logType = logType;
    }
    
     /**
     * Gets the location related to this log entry.
     *
     * @return the location description
     */

    public String getLocation() {
        return location;
    }
    
    /**
     * Sets the location related to this log entry.
     *
     * @param location the location description
     */

    public void setLocation(String location) {
        this.location = location;
    }
    
    /**
     * Gets the date and time when this log entry was recorded.
     *
     * @return the timestamp of the log
     */

    public LocalDateTime getLogTime() {
        return logTime;
    }
    
     /**
     * Sets the date and time when this log entry was recorded.
     *
     * @param logTime the timestamp of the log
     */

    public void setLogTime(LocalDateTime logTime) {
        this.logTime = logTime;
    }
}
