package com.algonquin.www.common.factory;

import com.algonquin.www.common.constants.VehicleTypeConstants;
import com.algonquin.www.domain.ComponentDTO;
import com.algonquin.www.domain.VehicleDTO;

import java.util.ArrayList;
import java.util.List;

public class ComponentFactory {

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

    private static ComponentDTO createComponent(VehicleDTO vehicle, String name) {
        ComponentDTO component = new ComponentDTO();
        component.setVehicleNumber(vehicle.getVehicleNumber());
        component.setName(name);
        component.setUsedHours(0.0);
        return component;
    }
}
