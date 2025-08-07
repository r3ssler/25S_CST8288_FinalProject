package com.algonquin.www.model;

import java.io.Serializable;
/**
 * Serializable model representing detailed information about a vehicle.
 * <p>
 * Contains fields such as vehicle number, type, energy type, consumption rate,
 * and assigned route.
 * </p>
 */

public class VehicleInfo implements Serializable {

    private String vehicleNumber;

    private String vehicleType;

    private String energyTYpe;

    private Double consumptionRate;

    private String route;
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
     * Gets the vehicle type (e.g., bus, train).
     *
     * @return the vehicle type
     */

    public String getVehicleType() {
        return vehicleType;
    }
      /**
     * Sets the vehicle type.
     *
     * @param vehicleType the vehicle type
     */

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
    /**
     * Gets the energy type used by the vehicle (e.g., diesel, electric).
     *
     * @return the energy type
     */

    public String getEnergyTYpe() {
        return energyTYpe;
    }
     /**
     * Sets the energy type used by the vehicle.
     *
     * @param energyTYpe the energy type
     */

    public void setEnergyTYpe(String energyTYpe) {
        this.energyTYpe = energyTYpe;
    }
    /**
     * Gets the consumption rate of the vehicle (e.g., fuel consumption).
     *
     * @return the consumption rate
     */

    public Double getConsumptionRate() {
        return consumptionRate;
    }
    /**
     * Sets the consumption rate of the vehicle.
     *
     * @param consumptionRate the consumption rate
     */

    public void setConsumptionRate(Double consumptionRate) {
        this.consumptionRate = consumptionRate;
    }
     /**
     * Gets the assigned route for the vehicle.
     *
     * @return the route
     */

    public String getRoute() {
        return route;
    }
    
    /**
     * Sets the assigned route for the vehicle.
     *
     * @param route the route
     */

    public void setRoute(String route) {
        this.route = route;
    }
}
