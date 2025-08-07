package com.algonquin.www.model;
/**
 * Model representing maintenance information for a vehicle.
 * <p>
 * Includes the vehicle number, maintenance type, and current status.
 * </p>
 */

public class VehicleMaintenanceInfo {

    private String vehicleNumber;

    private String type;

    private String status;
    /**
     * Gets the unique vehicle number.
     *
     * @return the vehicle number
     */

    public String getVehicleNumber() {
        return vehicleNumber;
    }
     /**
     * Sets the unique vehicle number.
     *
     * @param vehicleNumber the vehicle number
     */

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    /**
     * Gets the maintenance type for the vehicle.
     *
     * @return the maintenance type
     */

    public String getType() {
        return type;
    }
     /**
     * Sets the maintenance type for the vehicle.
     *
     * @param type the maintenance type
     */

    public void setType(String type) {
        this.type = type;
    }
     /**
     * Gets the current maintenance status of the vehicle.
     *
     * @return the status
     */

    public String getStatus() {
        return status;
    }
    /**
     * Sets the current maintenance status of the vehicle.
     *
     * @param status the status
     */

    public void setStatus(String status) {
        this.status = status;
    }
}
