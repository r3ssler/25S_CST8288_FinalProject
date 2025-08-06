package com.algonquin.www.model;

import java.util.List;

public class VehicleSearchResponse extends PageResponse {
    
    private List<VehicleInfo> data;

    public List<VehicleInfo> getData() {
        return data;
    }

    public void setData(List<VehicleInfo> data) {
        this.data = data;
    }
}
