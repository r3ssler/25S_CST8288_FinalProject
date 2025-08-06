package com.algonquin.www.model;

import java.util.List;

public class VehicleMaintenanceSearchResponse extends PageResponse {

    List<VehicleMaintenanceInfo> data;

    public List<VehicleMaintenanceInfo> getData() {
        return data;
    }
    
    public void setData(List<VehicleMaintenanceInfo> data) {
        this.data = data;
    }
}
