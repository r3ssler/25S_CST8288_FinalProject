package com.algonquin.www.dao;

import com.algonquin.www.domain.VehicleDTO;

import java.util.List;

public interface VehicleDAO {
    
    boolean addVehicle(VehicleDTO vehicle);
     
    List<VehicleDTO> search(String vehicleNumber);
    
    List<VehicleDTO> searchAll();

    List<VehicleDTO> searchByVehicleNumber(String vehicleNumber);
    
    boolean updateVehicle(VehicleDTO vehicle);
}
