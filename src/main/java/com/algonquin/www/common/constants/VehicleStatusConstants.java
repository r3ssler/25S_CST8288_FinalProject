package com.algonquin.www.common.constants;
/**
 * Defines constant string values representing different statuses of a vehicle.
 * <p>
 * These constants are used to standardize vehicle status indicators throughout the system.
 * </p>
 * 
 * <ul>
 *   <li>{@code NORMAL} - Indicates the vehicle is operating under normal conditions.</li>
 *   <li>{@code MAINTENANCE} - Indicates the vehicle is currently under maintenance.</li>
 * </ul>
 * 
 * <p><b>Example usage:</b></p>
 * <pre>
 * if (vehicle.getStatus().equals(VehicleStatusConstants.MAINTENANCE)) {
 *     // handle maintenance logic
 * }
 * </pre>
 * 
 * <p><b>Note:</b> This interface contains only constants and is not meant to be implemented.</p>
 * 
 * @author YourName
 */
public interface VehicleStatusConstants {

    /**
     *
     */
    String NORMAL = "normal";

    /**
     *
     */
    String MAINTENANCE = "maintenance";
}
