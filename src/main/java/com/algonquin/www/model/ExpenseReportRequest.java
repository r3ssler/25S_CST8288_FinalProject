package com.algonquin.www.model;
/**
 * Request model representing an expense report submission or query.
 * <p>
 * Contains details about the vehicle, expense type, amounts, and mileage readings.
 * </p>
 */


public class ExpenseReportRequest {
    private String vehicleNumber;
    private String type;
    private double expense;
    private double usageAmount;
    private double lastMile;
    private double currentMile;
    /**
     * Gets the vehicle number associated with the expense report.
     *
     * @return the vehicle number
     */


    public String getVehicleNumber() {
        return vehicleNumber;
    }
     /**
     * Sets the vehicle number associated with the expense report.
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
     * Sets the type/category of the expense.
     *
     * @param type the expense type
     */

    public void setType(String type) {
        this.type = type;
    }
    /**
     * Gets the amount of the expense.
     *
     * @return the expense amount
     */

    public double getExpense() {
        return expense;
    }
    /**
     * Sets the amount of the expense.
     *
     * @param expense the expense amount
     */

    public void setExpense(double expense) {
        this.expense = expense;
    }

    /**
     *
     * @return
     */
    public double getUsageAmount() {
        return usageAmount;
    }
     /**
     * Gets the usage amount related to the expense (e.g., fuel liters, hours).
     *
     * @param usageAmount
     */

    public void setUsageAmount(double usageAmount) {
        this.usageAmount = usageAmount;
    }
     /**
     * Gets the mileage reading at the last measurement.
     *
     * @return the last mileage reading
     */

    public double getLastMile() {
        return lastMile;
    }
    
     /**
     * Sets the mileage reading at the last measurement.
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
