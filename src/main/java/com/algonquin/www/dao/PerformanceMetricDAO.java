package com.algonquin.www.dao;

import com.algonquin.www.domain.PerformanceMetricDTO;
import java.util.List;

public interface PerformanceMetricDAO {
    
    List<PerformanceMetricDTO> selectAll();
    
    PerformanceMetricDTO selectByUserName(String userName);
    
    PerformanceMetricDTO getByUserId(Long userId);
    
    boolean update(PerformanceMetricDTO dto);

    boolean add(PerformanceMetricDTO dto);
}
