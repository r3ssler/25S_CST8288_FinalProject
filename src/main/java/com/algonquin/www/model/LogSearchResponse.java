package com.algonquin.www.model;

import java.util.List;

public class LogSearchResponse extends PageResponse {
    private List<LogInfo> data;

    public List<LogInfo> getData() {
        return data;
    }

    public void setData(List<LogInfo> data) {
        this.data = data;
    }
}
