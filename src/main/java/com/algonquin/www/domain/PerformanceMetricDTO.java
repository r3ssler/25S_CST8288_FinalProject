package com.algonquin.www.domain;

import java.io.Serializable;

/**
 * Data Transfer Object (DTO) representing performance metrics related to a user.
 * <p>
 * Contains information such as the user ID, user name, total trips, on-time trips,
 * and total time spent (in an appropriate unit, e.g., minutes or hours).
 * </p>
 */

public class PerformanceMetricDTO implements Serializable {
    private Long id;
    private Long userId;
    private String userName;
    private int totalTrip;
    private int totalOnTimeTrip;
    private int totalTime;
    
    
    /**
     * Gets the unique identifier of this performance metric record.
     *
     * @return the metric record id
     */

    public Long getId() {
        return id;
    }
    
    
    /**
     * Sets the unique identifier of this performance metric record.
     *
     * @param id the metric record id
     */

    public void setId(Long id) {
        this.id = id;
    }
    
     /**
     * Gets the ID of the user to whom this performance metric belongs.
     *
     * @return the user ID
     */

    public Long getUserId() {
        return userId;
    }
    
     /**
     * Sets the ID of the user to whom this performance metric belongs.
     *
     * @param userId the user ID
     */

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    
     /**
     * Gets the name of the user associated with these performance metrics.
     *
     * @return the user's name
     */

    public String getUserName() {
        return userName;
    }
    
     /**
     * Sets the name of the user associated with these performance metrics.
     *
     * @param userName the user's name
     */

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    /**
     * Gets the total number of trips completed by the user.
     *
     * @return the total trips count
     */

    public int getTotalTrip() {
        return totalTrip;
    }
    
     /**
     * Sets the total number of trips completed by the user.
     *
     * @param totalTrip the total trips count
     */

    public void setTotalTrip(int totalTrip) {
        this.totalTrip = totalTrip;
    }
    
     /**
     * Gets the total number of trips completed on time by the user.
     *
     * @return the total on-time trips count
     */

    public int getTotalOnTimeTrip() {
        return totalOnTimeTrip;
    }
    
     /**
     * Sets the total number of trips completed on time by the user.
     *
     * @param totalOnTimeTrip the total on-time trips count
     */

    public void setTotalOnTimeTrip(int totalOnTimeTrip) {
        this.totalOnTimeTrip = totalOnTimeTrip;
    }
    
    /**
     * Gets the total time spent on trips by the user.
     * <p>
     * The unit of time (e.g., minutes, seconds) should be documented and consistent.
     * </p>
     *
     * @return the total time spent
     */

    public int getTotalTime() {
        return totalTime;
    }
    
    /**
     * Sets the total time spent on trips by the user.
     * <p>
     * The unit of time (e.g., minutes, seconds) should be documented and consistent.
     * </p>
     *
     * @param totalTime the total time spent
     */

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }
}
