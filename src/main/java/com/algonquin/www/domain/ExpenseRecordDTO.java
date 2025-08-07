package com.algonquin.www.domain;

import java.io.Serializable;
/**
 * Data Transfer Object (DTO) representing an expense record related to a vehicle.
 * <p>
 * This class encapsulates details such as the vehicle number, expense type,
 * amount spent, usage metrics, and mileage readings.
 * </p>
 */

public class ExpenseRecordDTO implements Serializable {
    private Long id;
    private String vehicleNumber;
    private String type;
    private double expense;
    private double usageAmount;
    private double lastMile;
    private double currentMile;
    
    /**
     * Gets the unique identifier of the expense record.
     *
     * @return the expense record's id
     */

    public Long getId() {
        return id;
    }
    
     /**
     * Sets the unique identifier of the expense record.
     *
     * @param id the expense record's id
     */

    public void setId(Long id) {
        this.id = id;
    }
    
     /**
     * Gets the vehicle number associated with this expense record.
     *
     * @return the vehicle number
     */

    public String getVehicleNumber() {
        return vehicleNumber;
    }
    
    /**
     * Sets the vehicle number associated with this expense record.
     *
     * @param vehicleNumber the vehicle number
     */

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    
    /**
     * Gets the type/category of the expense.
     *
     * @return the expense type
     */

    public String getType() {
        return type;
    }
    
    /**
     * Gets the type/category of the expense.
     *
     * @param type
     */

    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * Gets the monetary value of the expense.
     *
     * @return the expense amount
     */


    public double getExpense() {
        return expense;
    }
    
     /**
     * Sets the monetary value of the expense.
     *
     * @param expense the expense amount
     */

    public void setExpense(double expense) {
        this.expense = expense;
    }
    
    /**
     * Gets the usage amount associated with the expense (e.g., liters of fuel, hours of service).
     *
     * @return the usage amount
     */

    public double getUsageAmount() {
        return usageAmount;
    }
    
     /**
     * Sets the usage amount associated with the expense (e.g., liters of fuel, hours of service).
     *
     * @param usageAmount the usage amount
     */

    public void setUsageAmount(double usageAmount) {
        this.usageAmount = usageAmount;
    }
    
     /**
     * Gets the mileage reading at the previous measurement.
     *
     * @return the last mileage reading
     */

    public double getLastMile() {
        return lastMile;
    }
    
     /**
     * Sets the mileage reading at the previous measurement.
     *
     * @param lastMile the last mileage reading
     */

    public void setLastMile(double lastMile) {
        this.lastMile = lastMile;
    }
    
     /**
     * Gets the current mileage reading.
     *
     * @return the current mileage reading
     */

    public double getCurrentMile() {
        return currentMile;
    }
    
     /**
     * Sets the current mileage reading.
     *
     * @param currentMile the current mileage reading
     */

    public void setCurrentMile(double currentMile) {
        this.currentMile = currentMile;
    }
}
