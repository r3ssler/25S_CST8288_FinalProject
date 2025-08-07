package com.algonquin.www.dao.impl;

import com.algonquin.www.common.db.DataSource;
import com.algonquin.www.dao.ExpenseRecordDAO;
import com.algonquin.www.domain.ExpenseRecordDTO;
import com.algonquin.www.model.ExpenseRecordSearchRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link ExpenseRecordDAO} interface for managing
 * expense records stored in the database.
 * <p>
 * Provides methods to search, add, and retrieve expense records.
 * Uses {@link DataSource} to obtain database connections.
 * </p>
 *
 * @author
 * @version 1.0
 * @since 2025-08-07
 */

public class ExpenseRecordDAOImpl implements ExpenseRecordDAO {
    /**
     * Searches expense records by vehicle number if provided,
     * otherwise returns all expense records.
     *
     * @param request the search criteria encapsulated in {@link ExpenseRecordSearchRequest}
     * @return list of matching {@link ExpenseRecordDTO} objects
     */
    
    @Override
    public List<ExpenseRecordDTO> expenseRecordSearch(ExpenseRecordSearchRequest request) {
        Connection con = DataSource.createConnection();
        String vehicleNumber = request.getVehicleNumber();
        String sql;
        PreparedStatement pstmt;
        List<ExpenseRecordDTO> records = new ArrayList<>();

        try {

            if (vehicleNumber != null && !vehicleNumber.isEmpty()) {
                sql = "SELECT * FROM ExpenseRecord WHERE vehicleNumber = ?";
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, vehicleNumber);
            } else {
                sql = "SELECT * FROM ExpenseRecord";
                pstmt = con.prepareStatement(sql);
            }


            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    ExpenseRecordDTO dto = new ExpenseRecordDTO();
                    dto.setId(rs.getLong("id"));
                    dto.setVehicleNumber(rs.getString("vehicleNumber"));
                    dto.setType(rs.getString("type"));
                    dto.setExpense(rs.getDouble("expense"));
                    dto.setUsageAmount(rs.getDouble("usageAmount"));
                    dto.setLastMile(rs.getDouble("lastMile"));
                    dto.setCurrentMile(rs.getDouble("currentMile"));
                    records.add(dto);
                }
            } finally {
                pstmt.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return records;
    }
    
     /**
     * Returns the count of expense records matching the search criteria.
     * Currently not implemented.
     *
     * @param request the search criteria
     * @return count of matching records (always 0 for now)
     */
    
    @Override
    public int count(ExpenseRecordSearchRequest request) {
        return 0;
    }
    
    /**
     * Adds a new expense record to the database.
     *
     * @param request the {@link ExpenseRecordDTO} to insert
     */
    
    @Override
    public void addExpenseRecord(ExpenseRecordDTO request) {
        Connection con = DataSource.createConnection();
        String sql = "INSERT INTO ExpenseRecord " +
                "(vehicleNumber, type, expense, usageAmount, lastMile, currentMile) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, request.getVehicleNumber());   
            ps.setString(2, request.getType());           
            ps.setDouble(3, request.getExpense());         
            ps.setDouble(4, request.getUsageAmount());
            ps.setDouble(5, request.getLastMile());
            ps.setDouble(6, request.getCurrentMile());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Retrieves all expense records from the database.
     *
     * @return list of all {@link ExpenseRecordDTO} objects
     */
   
    @Override
    public List<ExpenseRecordDTO> getAllExpenseRecords() {
        Connection connection = DataSource.createConnection();
        String sql = "SELECT * FROM ExpenseRecord";
        List<ExpenseRecordDTO> records = new ArrayList<>();

        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                ExpenseRecordDTO dto = new ExpenseRecordDTO();

                dto.setId(rs.getLong("id"));
                dto.setVehicleNumber(rs.getString("vehicleNumber"));
                dto.setType(rs.getString("type"));
                dto.setExpense(rs.getDouble("expense"));
                dto.setUsageAmount(rs.getDouble("usageAmount"));
                dto.setLastMile(rs.getDouble("lastMile"));
                dto.setCurrentMile(rs.getDouble("currentMile"));

                records.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return records;
    }
}
