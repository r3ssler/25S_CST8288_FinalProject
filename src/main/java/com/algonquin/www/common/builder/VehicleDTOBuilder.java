package com.algonquin.www.common.builder;

import com.algonquin.www.domain.VehicleDTO;
/**
 * Builder class for constructing {@link VehicleDTO} objects using a fluent API.
 * <p>
 * This class simplifies the creation of {@code VehicleDTO} instances by allowing
 * chained method calls to set various properties.
 * </p>
 *
 * <pre>
 * Example usage:
 * VehicleDTO vehicle = new VehicleDTOBuilder()
 *     .id(1L)
 *     .vehicleNumber("BUS123")
 *     .vehicleType("Bus")
 *     .energyTYpe("Electric")
 *     .consumptionRate(15.5)
 *     .maxPassengers(50)
 *     .route("Route A")
 *     .status("Active")
 *     .build();
 * </pre>
 * 
 * @author 
 */

public class VehicleDTOBuilder {
    /** The VehicleDTO instance being constructed. */
    private final VehicleDTO vehicle;

    /**
     * Constructs a new {@code VehicleDTOBuilder}.
     * Initializes an empty {@link VehicleDTO} object.
     */
    
    public VehicleDTOBuilder() {
        this.vehicle = new VehicleDTO();
    }
    
     /**
     * Sets the ID of the vehicle.
     *
     * @param id the unique identifier for the vehicle
     * @return the builder instance
     */
    
    
    public VehicleDTOBuilder id(Long id) {
        vehicle.setId(id);
        return this;
    }
    
    /**
     * Sets the vehicle number.
     *
     * @param vehicleNumber the vehicle's identification number
     * @return the builder instance
     */
   
    public VehicleDTOBuilder vehicleNumber(String vehicleNumber) {
        vehicle.setVehicleNumber(vehicleNumber);
        return this;
    }
    
    /**
     * Sets the vehicle type.
     *
     * @param vehicleType the type of vehicle (e.g., "Bus", "Tram")
     * @return the builder instance
     */
    
    public VehicleDTOBuilder vehicleType(String vehicleType) {
        vehicle.setVehicleType(vehicleType);
        return this;
    }
    
    
    
    /**
     * Sets the energy type of the vehicle.
     *
     * @param energyTYpe the energy source (e.g., "Diesel", "Electric")
     * @return the builder instance
     */
    
    public VehicleDTOBuilder energyTYpe(String energyTYpe) {
        vehicle.setEnergyType(energyTYpe);
        return this;
    }
   
    
    /**
     * Sets the consumption rate of the vehicle.
     *
     * @param consumptionRate the rate of energy/fuel consumption
     * @return the builder instance
     */
    
    public VehicleDTOBuilder consumptionRate(Double consumptionRate) {
        vehicle.setConsumptionRate(consumptionRate);
        return this;
    }
    
    /**
     * Sets the maximum number of passengers the vehicle can carry.
     *
     * @param maxPassengers the max passenger capacity
     * @return the builder instance
     */
    
     
    public VehicleDTOBuilder maxPassengers(Integer maxPassengers) {
        vehicle.setMaxPassengers(maxPassengers);
        return this;
    }
   
    
    
    
    /**
     * Sets the route assigned to the vehicle.
     *
     * @param route the route identifier or name
     * @return the builder instance
     */
    
    public VehicleDTOBuilder route(String route) {
        vehicle.setRoute(route);
        return this;
    }
    
    
    /**
     * Sets the current status of the vehicle.
     *
     * @param status the operational status (e.g., "Active", "Under Maintenance")
     * @return the builder instance
     */
    
    public VehicleDTOBuilder status(String status) {
        vehicle.setStatus(status);
        return this;
    }
   
    
     /**
     * Builds and returns the constructed {@link VehicleDTO} object.
     *
     * @return the configured VehicleDTO instance
     */
    
    public VehicleDTO build() {
        return vehicle;
    }
}
