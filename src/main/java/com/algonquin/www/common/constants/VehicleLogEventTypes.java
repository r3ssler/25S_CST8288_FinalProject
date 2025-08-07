package com.algonquin.www.common.constants;

/**
 * Defines constant string values representing different types of vehicle log events.
 * <p>
 * These constants standardize event types related to vehicle operations in the system.
 * </p>
 * 
 * <ul>
 *   <li>{@code END} - Indicates the end of a vehicle's operation or shift.</li>
 *   <li>{@code START} - Indicates the start of a vehicle's operation or shift.</li>
 *   <li>{@code BREAK} - Represents a break or pause in vehicle operation.</li>
 *   <li>{@code OUT_OF_SERVICE} - Indicates that the vehicle is out of service.</li>
 * </ul>
 * 
 * <p><b>Example usage:</b></p>
 * <pre>
 * if (logEvent.getType().equals(VehicleLogEventTypes.START)) {
 *     // handle vehicle start event
 * }
 * </pre>
 * 
 * <p><b>Note:</b> This interface is intended solely for constants and should not be implemented.</p>
 * 
 * @author YourName
 */

public interface VehicleLogEventTypes {

    /**
     *
     */
    String END = "end";

    /**
     *
     */
    String START = "start";

    /**
     *
     */
    String BREAK = "break";

    /**
     *
     */
    String OUT_OF_SERVICE = "outOfService";
}
