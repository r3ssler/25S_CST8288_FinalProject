package com.algonquin.www.domain;

import java.io.Serializable;

public class PerformanceMetricDTO implements Serializable {
    private Long id;
    private Long userId;
    private String userName;
    private int totalTrip;
    private int totalOnTimeTrip;
    private int totalTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getTotalTrip() {
        return totalTrip;
    }

    public void setTotalTrip(int totalTrip) {
        this.totalTrip = totalTrip;
    }

    public int getTotalOnTimeTrip() {
        return totalOnTimeTrip;
    }

    public void setTotalOnTimeTrip(int totalOnTimeTrip) {
        this.totalOnTimeTrip = totalOnTimeTrip;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }
}
