
package com.algonquin.www.common.constants;

/**
 * Defines constant string values representing different types of usage events in the transit system.
 * <p>
 * These constants can be used throughout the application to standardize event type references,
 * such as identifying vehicle types or maintenance events.
 * </p>
 * 
 * <ul>
 *   <li>{@code BUS} - Represents a bus usage event.</li>
 *   <li>{@code LIGHT_RAIL} - Represents a light rail usage event.</li>
 *   <li>{@code TRAIN} - Represents a train usage event.</li>
 *   <li>{@code MAINTENANCE} - Represents a maintenance event.</li>
 * </ul>
 * 
 * <p><b>Example usage:</b></p>
 * <pre>
 * if (eventType.equals(UsageEventTypes.BUS)) {
 *     // handle bus event
 * }
 * </pre>
 * 
 * <p><b>Note:</b> This interface only contains constants and is not meant to be implemented.</p>
 * 
 * @author
 */
public interface UsageEventTypes {

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

    /**
     *
     */
    String MAINTENANCE = "maintenance";}
