package com.algonquin.www.model;

import java.util.List;
/**
 * Response model for vehicle log search results with pagination support.
 * <p>
 * Extends {@link PageResponse} to include pagination metadata and
 * contains a list of {@link LogInfo} objects representing the matching logs.
 * </p>
 */

public class LogSearchResponse extends PageResponse {
    private List<LogInfo> data;
     /**
     * Gets the list of vehicle logs returned in the response.
     *
     * @return the list of {@link LogInfo} objects
     */

    public List<LogInfo> getData() {
        return data;
    }
      /**
     * Sets the list of vehicle logs returned in the response.
     *
     * @param data the list of {@link LogInfo} objects
     */

    public void setData(List<LogInfo> data) {
        this.data = data;
    }
}
