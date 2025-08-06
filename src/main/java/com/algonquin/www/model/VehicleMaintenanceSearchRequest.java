package com.algonquin.www.model;

public class VehicleMaintenanceSearchRequest extends PageRequest {

    private String vehicleNumber;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
}
