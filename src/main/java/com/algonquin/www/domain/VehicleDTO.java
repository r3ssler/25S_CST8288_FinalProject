package com.algonquin.www.domain;

import java.io.Serializable;
/**
 * Data Transfer Object (DTO) representing a Vehicle entity.
 * <p>
 * Contains properties such as vehicle number, type, energy consumption,
 * passenger capacity, route, and operational status.
 * </p>
 */

public class VehicleDTO implements Serializable {
    private Long id;
    private String vehicleNumber;
    private String vehicleType;
    private String energyType;
    private Double consumptionRate;
    private Integer maxPassengers;
    private String route;
    private String status;
    
     /**
     * Gets the unique identifier of the vehicle.
     *
     * @return the vehicle's id
     */

    public Long getId() {
        return id;
    }
    
    /**
     * Sets the unique identifier of the vehicle.
     *
     * @param id the vehicle's id
     */

    public void setId(Long id) {
        this.id = id;
    }
    
     /**
     * Gets the vehicle number (e.g., license plate or fleet number).
     *
     * @return the vehicle number
     */

    public String getVehicleNumber() {
        return vehicleNumber;
    }
    
    /**
     * Sets the vehicle number (e.g., license plate or fleet number).
     *
     * @param vehicleNumber the vehicle number
     */

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    
    /**
     * Gets the type of the vehicle (e.g., bus, tram, etc.).
     *
     * @return the vehicle type
     */

    public String getVehicleType() {
        return vehicleType;
    }
     /**
     * Sets the type of the vehicle (e.g., bus, tram, etc.).
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

    public String getEnergyType() {
        return energyType;
    }
    
      /**
     * Sets the energy type used by the vehicle (e.g., diesel, electric).
     *
     * @param energyType the energy type
     */

    public void setEnergyType(String energyType) {
        this.energyType = energyType;
    }
    
     /**
     * Gets the consumption rate of the vehicle (e.g., liters/hour, kWh/km).
     *
     * @return the consumption rate
     */

    public Double getConsumptionRate() {
        return consumptionRate;
    }
    
     /**
     * Sets the consumption rate of the vehicle (e.g., liters/hour, kWh/km).
     *
     * @param consumptionRate the consumption rate
     */

    public void setConsumptionRate(Double consumptionRate) {
        this.consumptionRate = consumptionRate;
    }
    
     /**
     * Gets the maximum passenger capacity of the vehicle.
     *
     * @return the maximum number of passengers
     */

    public Integer getMaxPassengers() {
        return maxPassengers;
    }
    /**
     * Sets the maximum passenger capacity of the vehicle.
     *
     * @param maxPassengers the maximum number of passengers
     */

    public void setMaxPassengers(Integer maxPassengers) {
        this.maxPassengers = maxPassengers;
    }
    /**
     * Gets the route that the vehicle operates on.
     *
     * @return the route
     */

    public String getRoute() {
        return route;
    }
     /**
     * Sets the route that the vehicle operates on.
     *
     * @param route the route
     */

    public void setRoute(String route) {
        this.route = route;
    }
     /**
     * Gets the operational status of the vehicle (e.g., active, maintenance).
     *
     * @return the status
     */

    public String getStatus() {
        return status;
    }
    /**
     * Sets the operational status of the vehicle (e.g., active, maintenance).
     *
     * @param status the status
     */

    public void setStatus(String status) {
        this.status = status;
    }
}
