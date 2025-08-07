package com.algonquin.www.dao.impl;

import com.algonquin.www.common.db.DataSource;
import com.algonquin.www.dao.AbstractGenericDAO;
import com.algonquin.www.dao.ComponentDAO;
import com.algonquin.www.domain.ComponentDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Implementation of the {@link ComponentDAO} interface for managing components
 * associated with vehicles in the database.
 * <p>
 * This class provides CRUD operations on the Component table, such as batch insertion,
 * searching by vehicle number, retrieving all components, and updating component details.
 * </p>
 *
 * <p>Uses {@link DataSource} to obtain database connections.</p>
 *
 * @author
 * @version 1.0
 * @since 2025-08-07
 */

public class ComponentDAOImpl extends AbstractGenericDAO implements ComponentDAO {
    
    /**
     * Adds a list of components to the database in batch.
     * 
     * @param components the list of {@link ComponentDTO} to add
     * @return true if all components are successfully added, false otherwise
     */
    
    @Override
    public boolean addComponents(List<ComponentDTO> components) {
        if (components == null || components.isEmpty()) {
            return false;
        }

        Connection connection = DataSource.createConnection();
        String sql = "INSERT INTO Component (vehicleNumber, name, usedHours) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            for (ComponentDTO component : components) {
                pstmt.setString(1, component.getVehicleNumber());
                pstmt.setString(2, component.getName());
                pstmt.setDouble(3, component.getUsedHours());
                pstmt.addBatch();
            }

            int[] result = pstmt.executeBatch();
            return Arrays.stream(result).allMatch(i -> i >= 0);

        } catch (Exception e) {
            e.printStackTrace(); 
            return false;
        }
    }
    
    /**
     * Finds components by vehicle number.
     * If vehicle number is null or empty, returns all components.
     * 
     * @param vehicleNumber the vehicle number to filter by
     * @return a list of matching {@link ComponentDTO} objects
     */

    @Override
    public List<ComponentDTO> findByVehicle(String vehicleNumber) {

        if (vehicleNumber != null && !vehicleNumber.isEmpty()) {
            return searchByVehicleNumber(vehicleNumber);
        } else {
            return searchAllComponents();
        }
    }
    
    /**
     * Retrieves all components from the database.
     * 
     * @return list of all {@link ComponentDTO} objects
     */

    public List<ComponentDTO> searchAllComponents() {
        List<ComponentDTO> components = new ArrayList<>();
        String sql = "SELECT * FROM Component";
        Connection connection = DataSource.createConnection();

        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                components.add(mapToComponentDTO(rs));
            }

        } catch (Exception e) {
            e.printStackTrace(); 
        }

        return components;
    }
    
    /**
     * Searches components by a specific vehicle number.
     * 
     * @param vehicleNumber the vehicle number to search for
     * @return list of matching {@link ComponentDTO} objects
     */
    
    private List<ComponentDTO> searchByVehicleNumber(String vehicleNumber) {
        List<ComponentDTO> components = new ArrayList<>();
        String sql = "SELECT * FROM Component WHERE vehicleNumber = ?";
        Connection connection = DataSource.createConnection();

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, vehicleNumber);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    components.add(mapToComponentDTO(rs));
                }
            }

        } catch (Exception e) {
            e.printStackTrace(); 
        }

        return components;
    }
    /**
     * Maps a JDBC {@link ResultSet} row to a {@link ComponentDTO}.
     * 
     * @param rs the {@link ResultSet} positioned at a row
     * @return the mapped {@link ComponentDTO}
     * @throws SQLException if a database access error occurs
     */
    private ComponentDTO mapToComponentDTO(ResultSet rs) throws SQLException {
        ComponentDTO dto = new ComponentDTO();
        dto.setId(rs.getLong("id"));
        dto.setVehicleNumber(rs.getString("vehicleNumber"));
        dto.setName(rs.getString("name"));
        dto.setUsedHours(rs.getDouble("usedHours"));
        return dto;
    }
    
    
    /**
     * Updates an existing component's details in the database.
     * 
     * @param componentDTO the {@link ComponentDTO} with updated information
     * @return true if the update was successful, false otherwise
     */

    @Override
    public boolean updateComponent(ComponentDTO componentDTO) {
        Connection con = DataSource.createConnection();
        String sql = "UPDATE Component SET name = ?, usedHours = ? WHERE id = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, componentDTO.getName());
            pstmt.setDouble(2, componentDTO.getUsedHours());
            pstmt.setLong(3, componentDTO.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
