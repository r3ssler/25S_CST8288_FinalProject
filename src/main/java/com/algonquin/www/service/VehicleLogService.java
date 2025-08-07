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
/**
 * Service class for handling vehicle log operations and updating performance metrics.
 * <p>
 * Provides functionality to search vehicle logs and upload new log entries.
 * Also updates user performance metrics based on vehicle log events.
 * </p>
 */

public class VehicleLogService {
    
    private VehicleLogDAO vehicleLogDAO;

    private PerformanceMetricDAO performanceMetricDAO;
     /**
     * Constructs a new VehicleLogService instance.
     * <p>
     * Initializes DAO implementations for vehicle logs and performance metrics.
     * </p>
     */

    public VehicleLogService() {
        vehicleLogDAO = new VehicleLogDAOImpl();
        performanceMetricDAO = new PerformanceMetricDAOImpl();
    }
     /**
     * Searches vehicle logs by vehicle number.
     *
     * @param vehicleNumber the vehicle number to filter logs
     * @return a list of {@link VehicleLogDTO} matching the vehicle number
     */

    public List<VehicleLogDTO> search(String vehicleNumber) {
        return vehicleLogDAO.search(vehicleNumber);
    }
    
     /**
     * Uploads a new vehicle log entry and updates the associated user’s performance metrics.
     *
     * @param request the {@link LogUploadRequest} containing log details
     * @param userDTO the {@link UserDTO} representing the user uploading the log
     * @return true if the upload process completes (successful or not); false if parameters are invalid
     */

    public boolean upload(LogUploadRequest request, UserDTO userDTO) {
        performance(request, userDTO);
        vehicleLog(request, userDTO);
        return true;
    }
    
     /**
     * Persists a vehicle log entry in the database.
     *
     * @param request the log upload request
     * @param userDTO the user performing the upload
     * @return true if the log was successfully added; false otherwise
     */

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
    
    
    /**
     * Updates the performance metrics of a user based on the log event.
     * <p>
     * Only processes metrics when the event type is "end" (case-insensitive).
     * Updates total trips, on-time trips (randomized 70% chance), and total time (random 20-60 minutes).
     * Inserts a new metric record if none exists for the user, otherwise updates existing.
     * </p>
     *
     * @param request the log upload request
     * @param userDTO the user performing the upload
     * @return true if the metric was successfully added or updated; false otherwise
     */

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
