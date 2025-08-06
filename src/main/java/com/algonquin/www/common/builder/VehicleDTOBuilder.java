package com.algonquin.www.common.builder;

import com.algonquin.www.domain.VehicleDTO;

public class VehicleDTOBuilder {
    private final VehicleDTO vehicle;

    public VehicleDTOBuilder() {
        this.vehicle = new VehicleDTO();
    }

    public VehicleDTOBuilder id(Long id) {
        vehicle.setId(id);
        return this;
    }
   
    public VehicleDTOBuilder vehicleNumber(String vehicleNumber) {
        vehicle.setVehicleNumber(vehicleNumber);
        return this;
    }
    
    public VehicleDTOBuilder vehicleType(String vehicleType) {
        vehicle.setVehicleType(vehicleType);
        return this;
    }
    
    public VehicleDTOBuilder energyTYpe(String energyTYpe) {
        vehicle.setEnergyType(energyTYpe);
        return this;
    }
   
    public VehicleDTOBuilder consumptionRate(Double consumptionRate) {
        vehicle.setConsumptionRate(consumptionRate);
        return this;
    }
    
     
    public VehicleDTOBuilder maxPassengers(Integer maxPassengers) {
        vehicle.setMaxPassengers(maxPassengers);
        return this;
    }
   
    public VehicleDTOBuilder route(String route) {
        vehicle.setRoute(route);
        return this;
    }
    
    
    public VehicleDTOBuilder status(String status) {
        vehicle.setStatus(status);
        return this;
    }
   
    public VehicleDTO build() {
        return vehicle;
    }
}
