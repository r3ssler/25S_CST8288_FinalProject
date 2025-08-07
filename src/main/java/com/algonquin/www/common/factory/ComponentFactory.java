package com.algonquin.www.common.factory;

import com.algonquin.www.common.constants.VehicleTypeConstants;
import com.algonquin.www.domain.ComponentDTO;
import com.algonquin.www.domain.VehicleDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Factory class responsible for creating a list of {@link ComponentDTO} objects
 * associated with a given {@link VehicleDTO}.
 * <p>
 * The factory creates a basic set of components common to all vehicles, such as
 * "Brakes", "Tires", and "Axle Bearings". Additionally, it adds specific components
 * depending on the vehicle type:
 * </p>
 * <ul>
 *   <li>Buses and Trains include "Engine Diagnostics".</li>
 *   <li>Light Rail vehicles include "Catenary", "Pantograph", and "Circuit Breakers".</li>
 * </ul>
 * 
 * <p>All components are initialized with zero used hours.</p>
 * 
 * <pre>
 * Example usage:
 * List&lt;ComponentDTO&gt; components = ComponentFactory.createComponentsForVehicle(vehicle);
 * </pre>
 * 
 * This class follows the Factory design pattern to encapsulate component creation logic.
 * 
 * @see VehicleDTO
 * @see ComponentDTO
 * @see VehicleTypeConstants
 */

public class ComponentFactory {
    
     /**
     * Creates a list of components associated with the specified vehicle.
     * 
     * @param vehicle the vehicle for which components are created
     * @return a list of {@link ComponentDTO} initialized for the vehicle
     */

    public static List<ComponentDTO> createComponentsForVehicle(VehicleDTO vehicle) {
        List<ComponentDTO> components = new ArrayList<>();

        components.add(createComponent(vehicle, "Brakes"));
        components.add(createComponent(vehicle, "Tires"));
        components.add(createComponent(vehicle, "Axle Bearings"));

        String type = vehicle.getVehicleType();

        if (VehicleTypeConstants.BUS.equalsIgnoreCase(type) || VehicleTypeConstants.TRAIN.equalsIgnoreCase(type)) {
            components.add(createComponent(vehicle, "Engine Diagnostics"));
        } else if (VehicleTypeConstants.LIGHT_RAIL.equalsIgnoreCase(type)) {
            components.add(createComponent(vehicle, "Catenary"));
            components.add(createComponent(vehicle, "Pantograph"));
            components.add(createComponent(vehicle, "Circuit Breakers"));
        }

        return components;
    }
    
    
    /**
     * Creates a single {@link ComponentDTO} with the given name, associated with the vehicle.
     * The component's used hours are initialized to 0.0.
     * 
     * @param vehicle the vehicle the component belongs to
     * @param name    the name of the component
     * @return the newly created {@link ComponentDTO}
     */

    private static ComponentDTO createComponent(VehicleDTO vehicle, String name) {
        ComponentDTO component = new ComponentDTO();
        component.setVehicleNumber(vehicle.getVehicleNumber());
        component.setName(name);
        component.setUsedHours(0.0);
        return component;
    }
}
