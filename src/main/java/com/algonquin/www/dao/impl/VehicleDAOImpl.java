
package com.algonquin.www.dao.impl;

import com.algonquin.www.common.db.DataSource;
import com.algonquin.www.dao.AbstractGenericDAO;
import com.algonquin.www.dao.VehicleDAO;
import com.algonquin.www.domain.VehicleDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAOImpl extends AbstractGenericDAO implements VehicleDAO {
    
    @Override
    public boolean addVehicle(VehicleDTO vehicle) {
        String sql = "INSERT INTO Vehicle (vehicleNumber, vehicleType, energyType, consumptionRate, maxPassengers, route, status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = DataSource.createConnection();

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, vehicle.getVehicleNumber());
            stmt.setString(2, vehicle.getVehicleType());
            stmt.setString(3, vehicle.getEnergyType());
            stmt.setDouble(4, vehicle.getConsumptionRate());
            stmt.setInt(5, vehicle.getMaxPassengers());
            stmt.setString(6, vehicle.getRoute());
            stmt.setString(7, vehicle.getStatus());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public List<VehicleDTO> search(String vehicleNumber) {
        if (vehicleNumber != null && !vehicleNumber.isEmpty()) {
            return searchByVehicleNumber(vehicleNumber);
        } else {
            return searchAll();
        }
    }
    

    @Override
    public List<VehicleDTO> searchAll() {
        List<VehicleDTO> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM Vehicle";
        Connection connection = DataSource.createConnection();

        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                vehicles.add(mapToVehicleDTO(rs));
            }

        } catch (Exception e) {
            e.printStackTrace(); 
        }

        return vehicles;
    }
    
    @Override
    public List<VehicleDTO> searchByVehicleNumber(String vehicleNumber) {
        List<VehicleDTO> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM Vehicle WHERE vehicleNumber = ?";
        Connection connection = DataSource.createConnection();

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, vehicleNumber);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    vehicles.add(mapToVehicleDTO(rs));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return vehicles;
    }
    
    private VehicleDTO mapToVehicleDTO(ResultSet rs) throws SQLException {
        VehicleDTO vehicle = new VehicleDTO();
        vehicle.setId(rs.getLong("id"));
        vehicle.setVehicleNumber(rs.getString("vehicleNumber"));
        vehicle.setVehicleType(rs.getString("vehicleType"));
        vehicle.setEnergyType(rs.getString("energyType"));
        vehicle.setConsumptionRate(rs.getDouble("consumptionRate"));
        vehicle.setMaxPassengers(rs.getInt("maxPassengers"));
        vehicle.setRoute(rs.getString("route"));
        vehicle.setStatus(rs.getString("status"));
        return vehicle;
    }
    
    @Override
    public boolean updateVehicle(VehicleDTO vehicle) {
        String sql = "UPDATE Vehicle SET " +
                "vehicleNumber = ?, " +
                "vehicleType = ?, " +
                "energyType = ?, " +
                "consumptionRate = ?, " +
                "maxPassengers = ?, " +
                "route = ?, " +
                "status = ? " +
                "WHERE id = ?";

        Connection connection = DataSource.createConnection();

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, vehicle.getVehicleNumber());
            stmt.setString(2, vehicle.getVehicleType());
            stmt.setString(3, vehicle.getEnergyType());
            stmt.setDouble(4, vehicle.getConsumptionRate());
            stmt.setInt(5, vehicle.getMaxPassengers());
            stmt.setString(6, vehicle.getRoute());
            stmt.setString(7, vehicle.getStatus());
            stmt.setLong(8, vehicle.getId());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }}
