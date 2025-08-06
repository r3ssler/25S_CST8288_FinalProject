package com.algonquin.www.common.factory;

import com.algonquin.www.common.builder.VehicleDTOBuilder;
import com.algonquin.www.common.constants.VehicleStatusConstants;
import com.algonquin.www.common.constants.VehicleTypeConstants;
import com.algonquin.www.domain.VehicleDTO;

public class VehicleFactory {
    
    public static VehicleDTO createVehicle(String vehicleNumber, String vehicleType, String route) {
        VehicleDTOBuilder builder = new VehicleDTOBuilder();

        if (VehicleTypeConstants.BUS.equalsIgnoreCase(vehicleType)) {
            return builder
                    .vehicleNumber(vehicleNumber)
                    .route(route)
                    .vehicleType("Bus")
                    .energyTYpe("Diesel")
                    .consumptionRate(10.0)
                    .maxPassengers(40)
                    .status(VehicleStatusConstants.NORMAL)
                    .build();

        } else if (VehicleTypeConstants.LIGHT_RAIL.equalsIgnoreCase(vehicleType)) {
            return builder
                    .vehicleNumber(vehicleNumber)
                    .route(route)
                    .vehicleType("Electric Light Rail")
                    .energyTYpe("Electric")
                    .consumptionRate(5.5)
                    .maxPassengers(100)
                    .status(VehicleStatusConstants.NORMAL)
                    .build();

        } else if (VehicleTypeConstants.TRAIN.equalsIgnoreCase(vehicleType)) {
            return builder
                    .vehicleNumber(vehicleNumber)
                    .route(route)
                    .vehicleType("Diesel-Electric Train")
                    .energyTYpe("Diesel-Electric")
                    .consumptionRate(20.0)
                    .maxPassengers(200)
                    .status(VehicleStatusConstants.NORMAL)
                    .build();

        } else {
            throw new IllegalArgumentException("Unknown vehicle type: " + vehicleType);
        }
    }
}
