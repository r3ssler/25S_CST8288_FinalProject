package com.algonquin.www.model;
/**
 * Model class representing the performance metrics of an operator.
 * <p>
 * Includes operator identification, name, on-time performance rate,
 * total number of trips, and total operating time.
 * </p>
 */

public class OperatorPerformanceInfo {
    private String operatorId;
    private String operatorName;
    private double onTimeRate;
    private int totalTrip;
    private double totalTime;
    
    /**
     *
     * @return
     */
    public String getOperatorId() {
        return operatorId;
    }
    /**
     * Sets the unique identifier of the operator.
     *
     * @param operatorId the operator ID
     */

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }
    /**
     * Gets the name of the operator.
     *
     * @return the operator's name
     */

    public String getOperatorName() {
        return operatorName;
    }
     /**
     * Sets the name of the operator.
     *
     * @param operatorName the operator's name
     */

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }
    /**
     * Gets the on-time performance rate of the operator.
     * <p>
     * This value represents the percentage or ratio of trips completed on time.
     * </p>
     *
     * @return the on-time rate as a double
     */

    public double getOnTimeRate() {
        return onTimeRate;
    }
     /**
     * Sets the on-time performance rate of the operator.
     *
     * @param onTimeRate the on-time rate as a double
     */

    public void setOnTimeRate(double onTimeRate) {
        this.onTimeRate = onTimeRate;
    }
    /**
     * Gets the total number of trips completed by the operator.
     *
     * @return the total trip count
     */

    public int getTotalTrip() {
        return totalTrip;
    }
    /**
     * Sets the total number of trips completed by the operator.
     *
     * @param totalTrip the total trip count
     */

    public void setTotalTrip(int totalTrip) {
        this.totalTrip = totalTrip;
    }
     /**
     * Gets the total operating time of the operator.
     * <p>
     * The unit is typically in hours or minutes, depending on usage context.
     * </p>
     *
     * @return the total operating time
     */

    public double getTotalTime() {
        return totalTime;
    }
    /**
     * Sets the total operating time of the operator.
     *
     * @param totalTime the total operating time
     */

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }
}
