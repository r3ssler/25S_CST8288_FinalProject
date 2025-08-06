package com.algonquin.www.model;

public class OperatorPerformanceInfo {
    private String operatorId;
    private String operatorName;
    private double onTimeRate;
    private int totalTrip;
    private double totalTime;

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public double getOnTimeRate() {
        return onTimeRate;
    }

    public void setOnTimeRate(double onTimeRate) {
        this.onTimeRate = onTimeRate;
    }

    public int getTotalTrip() {
        return totalTrip;
    }

    public void setTotalTrip(int totalTrip) {
        this.totalTrip = totalTrip;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }
}
