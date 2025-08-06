
package com.algonquin.www.dao;

import com.algonquin.www.domain.VehicleLogDTO;

import java.util.List;

public interface VehicleLogDAO {
    
    List<VehicleLogDTO> search(String vehicleNumber);
     
    boolean addLog(VehicleLogDTO log);
}
