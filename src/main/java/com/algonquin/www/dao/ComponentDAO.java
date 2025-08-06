package com.algonquin.www.dao;

import com.algonquin.www.domain.ComponentDTO;

import java.util.List;

public interface ComponentDAO {
    
    boolean addComponents(List<ComponentDTO> components);
    
    List<ComponentDTO> findByVehicle(String vehicleNumber);
    
    boolean updateComponent(ComponentDTO componentDTO);
}
