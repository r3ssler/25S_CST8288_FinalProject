package com.algonquin.www.model;

/**
 * Model class representing efficiency metrics across different vehicle types
 * and maintenance.
 * <p>
 * Holds efficiency values for buses, light rail vehicles, trains, and maintenance.
 * </p>
 */

public class EfficiencyMetricsResponse {
    private double bus;
    private double lightRail;
    private double train;
    private double maintenance;
    
    /**
     * Gets the efficiency metric for buses.
     *
     * @return the bus efficiency value
     */

    public double getBus() {
        return bus;
    }
    
     /**
     * Sets the efficiency metric for buses.
     *
     * @param bus the bus efficiency value
     */

    public void setBus(double bus) {
        this.bus = bus;
    }
    
    /**
     * Gets the efficiency metric for light rail vehicles.
     *
     * @return the light rail efficiency value
     */

    public double getLightRail() {
        return lightRail;
    }
    
    /**
     * Sets the efficiency metric for light rail vehicles.
     *
     * @param lightRail the light rail efficiency value
     */

    public void setLightRail(double lightRail) {
        this.lightRail = lightRail;
    }
    
     /**
     * Gets the efficiency metric for trains.
     *
     * @return the train efficiency value
     */

    public double getTrain() {
        return train;
    }
    
    /**
     * Sets the efficiency metric for trains.
     *
     * @param train the train efficiency value
     */

    public void setTrain(double train) {
        this.train = train;
    }
     /**
     * Gets the efficiency metric related to maintenance.
     *
     * @return the maintenance efficiency value
     */

    public double getMaintenance() {
        return maintenance;
    }
     /**
     * Sets the efficiency metric related to maintenance.
     *
     * @param maintenance the maintenance efficiency value
     */

    public void setMaintenance(double maintenance) {
        this.maintenance = maintenance;
    }
}
