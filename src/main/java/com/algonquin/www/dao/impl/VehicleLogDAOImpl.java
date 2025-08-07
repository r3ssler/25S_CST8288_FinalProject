package com.algonquin.www.dao.impl;

import com.algonquin.www.common.db.DataSource;
import com.algonquin.www.dao.AbstractGenericDAO;
import com.algonquin.www.dao.VehicleLogDAO;
import com.algonquin.www.domain.VehicleLogDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link VehicleLogDAO} for managing VehicleLog entities in the database.
 * <p>
 * Provides methods to search for vehicle logs by vehicle number and to add new vehicle logs.
 * </p>
 */


public class VehicleLogDAOImpl extends AbstractGenericDAO implements VehicleLogDAO {
    
     /**
     * Searches for vehicle logs associated with a specific vehicle number.
     * <p>
     * Retrieves all logs for the given vehicle number ordered by log time in descending order.
     * </p>
     *
     * @param vehicleNumber the vehicle number to search logs for
     * @return a list of {@link VehicleLogDTO} objects representing the logs; empty list if none found
     */
    
    @Override
    public List<VehicleLogDTO> search(String vehicleNumber) {
        List<VehicleLogDTO> logs = new ArrayList<>();

        String sql = "SELECT id, vehicleNumber, logType, location, logTime FROM VehicleLog WHERE vehicleNumber = ? ORDER BY logTime DESC";
        Connection conn = DataSource.createConnection();

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, vehicleNumber);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    VehicleLogDTO log = new VehicleLogDTO();
                    log.setId(rs.getLong("id"));
                    log.setVehicleNumber(rs.getString("vehicleNumber"));
                    log.setLogType(rs.getString("logType"));
                    log.setLocation(rs.getString("location"));
                    log.setLogTime(rs.getTimestamp("logTime").toLocalDateTime());
                    logs.add(log);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return logs;
    }
    
    /**
     * Adds a new vehicle log entry to the database.
     *
     * @param log the {@link VehicleLogDTO} containing log details to insert
     * @return {@code true} if the log was successfully inserted; {@code false} otherwise
     */

    @Override
    public boolean addLog(VehicleLogDTO log) {
        String sql = "INSERT INTO VehicleLog (vehicleNumber, logType, location, logTime) VALUES (?, ?, ?, ?)";
        Connection conn = DataSource.createConnection();

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, log.getVehicleNumber());
            stmt.setString(2, log.getLogType());
            stmt.setString(3, log.getLocation());
            stmt.setTimestamp(4, Timestamp.valueOf(log.getLogTime()));

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
