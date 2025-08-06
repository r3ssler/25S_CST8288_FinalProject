package com.algonquin.www.service;

import com.algonquin.www.dao.PerformanceMetricDAO;
import com.algonquin.www.dao.VehicleLogDAO;
import com.algonquin.www.dao.impl.PerformanceMetricDAOImpl;
import com.algonquin.www.dao.impl.VehicleLogDAOImpl;
import com.algonquin.www.domain.PerformanceMetricDTO;
import com.algonquin.www.domain.UserDTO;
import com.algonquin.www.domain.VehicleLogDTO;
import com.algonquin.www.model.LogSearchRequest;
import com.algonquin.www.model.LogSearchResponse;
import com.algonquin.www.model.LogUploadRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public class VehicleLogService {
    
    private VehicleLogDAO vehicleLogDAO;

    private PerformanceMetricDAO performanceMetricDAO;

    public VehicleLogService() {
        vehicleLogDAO = new VehicleLogDAOImpl();
        performanceMetricDAO = new PerformanceMetricDAOImpl();
    }

    public List<VehicleLogDTO> search(String vehicleNumber) {
        return vehicleLogDAO.search(vehicleNumber);
    }

    public boolean upload(LogUploadRequest request, UserDTO userDTO) {
        performance(request, userDTO);
        vehicleLog(request, userDTO);
        return true;
    }

    private boolean vehicleLog(LogUploadRequest request, UserDTO userDTO) {
        if (request == null || userDTO == null) {
            return false;
        }

        if (request.getVehicleNumber() == null || request.getEventType() == null || request.getLocation() == null) {
            return false;
        }

        VehicleLogDTO log = new VehicleLogDTO();
        log.setVehicleNumber(request.getVehicleNumber());
        log.setLogType(request.getEventType());
        log.setLocation(request.getLocation());
        log.setLogTime(LocalDateTime.now()); 

        return vehicleLogDAO.addLog(log);
    }

    private boolean performance(LogUploadRequest request, UserDTO userDTO) {
        if (request == null || request.getEventType() == null) {
            return false;
        }

        if (!"end".equalsIgnoreCase(request.getEventType())) {
            return true;
        }

        try {
            Long currentUserId = userDTO.getId();  
            String currentUserName = userDTO.getUsername();

            boolean insert = false;
            PerformanceMetricDTO metric = performanceMetricDAO.getByUserId(currentUserId);
            if (metric == null) {
                metric = new PerformanceMetricDTO();
                metric.setUserId(currentUserId);
                metric.setUserName(currentUserName);
                metric.setTotalTrip(0);
                metric.setTotalOnTimeTrip(0);
                metric.setTotalTime(0);
                insert = true;
            }

            metric.setTotalTrip(metric.getTotalTrip() + 1);

            if (Math.random() < 0.7) {
                metric.setTotalOnTimeTrip(metric.getTotalOnTimeTrip() + 1);
            }

            int addedTime = 20 + new Random().nextInt(41);
            metric.setTotalTime(metric.getTotalTime() + addedTime);

            if (insert) {
                return performanceMetricDAO.add(metric);
            } else {
                return performanceMetricDAO.update(metric);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
