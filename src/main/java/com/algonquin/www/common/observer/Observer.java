package com.algonquin.www.common.observer;

import com.algonquin.www.model.ExpenseReportRequest;

public interface Observer {
     
    boolean report(ExpenseReportRequest request);
}
