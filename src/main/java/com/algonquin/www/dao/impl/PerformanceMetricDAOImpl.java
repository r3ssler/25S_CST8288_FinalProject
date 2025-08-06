
package com.algonquin.www.dao.impl;

import com.algonquin.www.common.db.DataSource;
import com.algonquin.www.dao.AbstractGenericDAO;
import com.algonquin.www.dao.PerformanceMetricDAO;
import com.algonquin.www.domain.PerformanceMetricDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PerformanceMetricDAOImpl extends AbstractGenericDAO implements PerformanceMetricDAO {

    @Override
    public List<PerformanceMetricDTO> selectAll() {
        List<PerformanceMetricDTO> metrics = new ArrayList<>();
        String sql = "SELECT id, userId, userName, totalTrip, totalOnTimeTrip, totalTime FROM PerformanceMetric";
        Connection conn = DataSource.createConnection();

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                PerformanceMetricDTO metric = new PerformanceMetricDTO();
                metric.setId(rs.getLong("id"));
                metric.setUserId(rs.getLong("userId"));
                metric.setUserName(rs.getString("userName"));
                metric.setTotalTrip(rs.getInt("totalTrip"));
                metric.setTotalOnTimeTrip(rs.getInt("totalOnTimeTrip"));
                metric.setTotalTime(rs.getInt("totalTime"));

                metrics.add(metric);
            }

        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return metrics;
    }
    
    @Override
    public PerformanceMetricDTO selectByUserName(String userName) {
        String sql = "SELECT id, userId, userName, totalTrip, totalOnTimeTrip, totalTime FROM PerformanceMetric WHERE userName = ?";
        PerformanceMetricDTO metric = null;
        Connection conn = DataSource.createConnection();

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, userName);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    metric = new PerformanceMetricDTO();
                    metric.setId(rs.getLong("id"));
                    metric.setUserId(rs.getLong("userId"));
                    metric.setUserName(rs.getString("userName"));
                    metric.setTotalTrip(rs.getInt("totalTrip"));
                    metric.setTotalOnTimeTrip(rs.getInt("totalOnTimeTrip"));
                    metric.setTotalTime(rs.getInt("totalTime"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return metric;
    }
    
    @Override
    public PerformanceMetricDTO getByUserId(Long userId) {
        String sql = "SELECT id, userId, userName, totalTrip, totalOnTimeTrip, totalTime FROM PerformanceMetric WHERE userId = ?";
        Connection conn = DataSource.createConnection();

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, userId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    PerformanceMetricDTO dto = new PerformanceMetricDTO();
                    dto.setId(rs.getLong("id"));
                    dto.setUserId(rs.getLong("userId"));
                    dto.setUserName(rs.getString("userName"));
                    dto.setTotalTrip(rs.getInt("totalTrip"));
                    dto.setTotalOnTimeTrip(rs.getInt("totalOnTimeTrip"));
                    dto.setTotalTime(rs.getInt("totalTime"));
                    return dto;
                }
            }

        } catch (Exception e) {
            e.printStackTrace(); 
        }

        return null;
    }
    
    @Override
    public boolean update(PerformanceMetricDTO dto) {
        String sql = "UPDATE PerformanceMetric SET totalTrip = ?, totalOnTimeTrip = ?, totalTime = ? WHERE userId = ?";
        Connection conn = DataSource.createConnection();

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, dto.getTotalTrip());
            stmt.setInt(2, dto.getTotalOnTimeTrip());
            stmt.setInt(3, dto.getTotalTime());
            stmt.setLong(4, dto.getUserId());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;

        } catch (Exception e) {
            e.printStackTrace(); 
            return false;
        }
    }
    
    @Override
    public boolean add(PerformanceMetricDTO dto) {
        Connection connection = DataSource.createConnection();
        String sql = "INSERT INTO PerformanceMetric (userId, userName, totalTrip, totalOnTimeTrip, totalTime) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setLong(1, dto.getUserId());
            pstmt.setString(2, dto.getUserName());
            pstmt.setInt(3, dto.getTotalTrip());
            pstmt.setInt(4, dto.getTotalOnTimeTrip());
            pstmt.setInt(5, dto.getTotalTime());

            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }    }

}
