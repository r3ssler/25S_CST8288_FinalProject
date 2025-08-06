package com.algonquin.www.dao.impl;

import com.algonquin.www.common.db.DataSource;
import com.algonquin.www.dao.AbstractGenericDAO;
import com.algonquin.www.dao.VehicleLogDAO;
import com.algonquin.www.domain.VehicleLogDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class VehicleLogDAOImpl extends AbstractGenericDAO implements VehicleLogDAO {
    
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
