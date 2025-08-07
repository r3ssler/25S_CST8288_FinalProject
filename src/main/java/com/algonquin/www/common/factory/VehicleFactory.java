package com.algonquin.www.common.factory;

import com.algonquin.www.common.builder.VehicleDTOBuilder;
import com.algonquin.www.common.constants.VehicleStatusConstants;
import com.algonquin.www.common.constants.VehicleTypeConstants;
import com.algonquin.www.domain.VehicleDTO;

/**
 * Factory class responsible for creating {@link VehicleDTO} instances
 * based on the vehicle type.
 * <p>
 * This class uses the {@link VehicleDTOBuilder} to construct vehicles
 * with predefined properties such as energy type, consumption rate,
 * maximum passengers, and status depending on the vehicle type.
 * </p>
 * 
 * <p>Supported vehicle types:
 * <ul>
 *   <li>Bus</li>
 *   <li>Light Rail</li>
 *   <li>Train</li>
 * </ul>
 * </p>
 * 
 * <pre>
 * Example usage:
 * VehicleDTO bus = VehicleFactory.createVehicle("BUS123", VehicleTypeConstants.BUS, "Route A");
 * </pre>
 * 
 * @throws IllegalArgumentException if the provided vehicle type is not recognized
 * 
 * @see VehicleDTO
 * @see VehicleDTOBuilder
 * @see VehicleTypeConstants
 * @see VehicleStatusConstants
 */

public class VehicleFactory {
    
     /**
     * Creates and returns a {@link VehicleDTO} object for the given vehicle number,
     * type, and route.
     * <p>
     * The vehicle properties such as energy type, consumption rate, max passengers,
     * and status are set according to the vehicle type.
     * </p>
     *
     * @param vehicleNumber the unique identifier of the vehicle
     * @param vehicleType the type of the vehicle (e.g., "bus", "lightRail", "train")
     * @param route the route assigned to the vehicle
     * @return a fully constructed {@link VehicleDTO} instance
     * @throws IllegalArgumentException if the vehicle type is unknown
     */
    
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
