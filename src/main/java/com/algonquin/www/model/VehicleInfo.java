package com.algonquin.www.model;

import java.io.Serializable;

public class VehicleInfo implements Serializable {

    private String vehicleNumber;

    private String vehicleType;

    private String energyTYpe;

    private Double consumptionRate;

    private String route;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getEnergyTYpe() {
        return energyTYpe;
    }

    public void setEnergyTYpe(String energyTYpe) {
        this.energyTYpe = energyTYpe;
    }

    public Double getConsumptionRate() {
        return consumptionRate;
    }

    public void setConsumptionRate(Double consumptionRate) {
        this.consumptionRate = consumptionRate;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
}
