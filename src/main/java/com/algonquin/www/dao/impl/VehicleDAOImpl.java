
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

/**
 * Implementation of {@link VehicleDAO} for managing Vehicle entities in the database.
 * <p>
 * Provides CRUD operations such as adding, searching, and updating vehicle records
 * using JDBC connections obtained from {@link DataSource}.
 * </p>
 */

public class VehicleDAOImpl extends AbstractGenericDAO implements VehicleDAO {
    
    /**
     * Adds a new vehicle record to the database.
     *
     * @param vehicle the {@link VehicleDTO} containing vehicle details to add
     * @return {@code true} if the insertion was successful, {@code false} otherwise
     */
    
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
    
     /**
     * Searches vehicles by vehicle number or returns all vehicles if the number is null or empty.
     *
     * @param vehicleNumber the vehicle number to search by; if null or empty, returns all vehicles
     * @return a list of {@link VehicleDTO} matching the search criteria
     */
    
    @Override
    public List<VehicleDTO> search(String vehicleNumber) {
        if (vehicleNumber != null && !vehicleNumber.isEmpty()) {
            return searchByVehicleNumber(vehicleNumber);
        } else {
            return searchAll();
        }
    }
    
     /**
     * Retrieves all vehicles from the database.
     *
     * @return a list of all {@link VehicleDTO} objects in the database
     */
    

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
    
     /**
     * Searches for vehicles by a specific vehicle number.
     *
     * @param vehicleNumber the vehicle number to search for
     * @return a list of {@link VehicleDTO} that match the given vehicle number
     */
    
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
    
     /**
     * Maps the current row of the given {@link ResultSet} to a {@link VehicleDTO} object.
     *
     * @param rs the {@link ResultSet} positioned at a valid row
     * @return a {@link VehicleDTO} populated with data from the current row
     * @throws SQLException if a database access error occurs
     */
    
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
    
    /**
     * Updates an existing vehicle record in the database.
     *
     * @param vehicle the {@link VehicleDTO} containing updated vehicle details
     * @return {@code true} if the update was successful, {@code false} otherwise
     */
    
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
