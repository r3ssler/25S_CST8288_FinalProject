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

public class ComponentDAOImpl extends AbstractGenericDAO implements ComponentDAO {
    
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

    @Override
    public List<ComponentDTO> findByVehicle(String vehicleNumber) {

        if (vehicleNumber != null && !vehicleNumber.isEmpty()) {
            return searchByVehicleNumber(vehicleNumber);
        } else {
            return searchAllComponents();
        }
    }

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
    
    private ComponentDTO mapToComponentDTO(ResultSet rs) throws SQLException {
        ComponentDTO dto = new ComponentDTO();
        dto.setId(rs.getLong("id"));
        dto.setVehicleNumber(rs.getString("vehicleNumber"));
        dto.setName(rs.getString("name"));
        dto.setUsedHours(rs.getDouble("usedHours"));
        return dto;
    }

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
