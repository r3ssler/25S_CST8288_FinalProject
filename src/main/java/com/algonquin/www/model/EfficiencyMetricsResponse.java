package com.algonquin.www.model;

public class EfficiencyMetricsResponse {
    private double bus;
    private double lightRail;
    private double train;
    private double maintenance;

    public double getBus() {
        return bus;
    }

    public void setBus(double bus) {
        this.bus = bus;
    }

    public double getLightRail() {
        return lightRail;
    }

    public void setLightRail(double lightRail) {
        this.lightRail = lightRail;
    }

    public double getTrain() {
        return train;
    }

    public void setTrain(double train) {
        this.train = train;
    }

    public double getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(double maintenance) {
        this.maintenance = maintenance;
    }
}
