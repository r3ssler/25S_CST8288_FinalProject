package com.algonquin.www.common.constants;
/**
 * Defines constant string values representing different types of vehicles.
 * <p>
 * These constants are used to standardize references to vehicle types across the system.
 * </p>
 * 
 * <ul>
 *   <li>{@code BUS} - Represents a bus vehicle type.</li>
 *   <li>{@code LIGHT_RAIL} - Represents a light rail vehicle type.</li>
 *   <li>{@code TRAIN} - Represents a train vehicle type.</li>
 * </ul>
 * 
 * <p><b>Example usage:</b></p>
 * <pre>
 * if (vehicle.getType().equals(VehicleTypeConstants.BUS)) {
 *     // handle bus-specific logic
 * }
 * </pre>
 * 
 * <p><b>Note:</b> This interface only contains constants and should not be implemented.</p>
 * 
 * @author YourName
 */
public interface VehicleTypeConstants {

    /**
     *
     */
    String BUS = "bus";

    /**
     *
     */
    String LIGHT_RAIL = "lightRail";

    /**
     *
     */
    String TRAIN = "train";
}
