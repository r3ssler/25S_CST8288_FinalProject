package com.algonquin.www.domain;

import java.io.Serializable;

public class ExpenseRecordDTO implements Serializable {
    private Long id;
    private String vehicleNumber;
    private String type;
    private double expense;
    private double usageAmount;
    private double lastMile;
    private double currentMile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getExpense() {
        return expense;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }

    public double getUsageAmount() {
        return usageAmount;
    }

    public void setUsageAmount(double usageAmount) {
        this.usageAmount = usageAmount;
    }

    public double getLastMile() {
        return lastMile;
    }

    public void setLastMile(double lastMile) {
        this.lastMile = lastMile;
    }

    public double getCurrentMile() {
        return currentMile;
    }

    public void setCurrentMile(double currentMile) {
        this.currentMile = currentMile;
    }
}
