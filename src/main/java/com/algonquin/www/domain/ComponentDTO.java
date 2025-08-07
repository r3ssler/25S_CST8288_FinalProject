package com.algonquin.www.domain;

import java.io.Serializable;
/**
 * Data Transfer Object (DTO) representing a Component entity.
 * <p>
 * Contains details about a vehicle component including its identifier,
 * associated vehicle number, name, and the number of hours it has been used.
 * </p>
 */

public class ComponentDTO implements Serializable {
    private Long id;
    private String vehicleNumber;
    private String name;
    private double usedHours;
    /**
     * Gets the unique identifier of the component.
     *
     * @return the component's id
     */

    public Long getId() {
        return id;
    }
    
    /**
     * Sets the unique identifier of the component.
     *
     * @param id the component's id
     */

    public void setId(Long id) {
        this.id = id;
    }
    
     /**
     * Gets the vehicle number to which this component belongs.
     *
     * @return the associated vehicle number
     */

    public String getVehicleNumber() {
        return vehicleNumber;
    }
    
     /**
     * Sets the vehicle number to which this component belongs.
     *
     * @param vehicleNumber the associated vehicle number
     */
    
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    
    /**
     * Gets the name of the component.
     *
     * @return the component's name
     */

    public String getName() {
        return name;
    }
    
    /**
     * Sets the name of the component.
     *
     * @param name the component's name
     */

    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Gets the total used hours of the component.
     *
     * @return the number of hours the component has been used
     */

    public double getUsedHours() {
        return usedHours;
    }
    
     /**
     * Sets the total used hours of the component.
     *
     * @param usedHours the number of hours the component has been used
     */

    public void setUsedHours(double usedHours) {
        this.usedHours = usedHours;
    }
}
