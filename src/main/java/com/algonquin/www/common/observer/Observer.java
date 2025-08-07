package com.algonquin.www.common.observer;

import com.algonquin.www.model.ExpenseReportRequest;
/**
 * Observer interface defining a contract for classes that want to be notified
 * about {@link ExpenseReportRequest} events.
 * <p>
 * Implementing classes should provide logic to handle or process expense report requests
 * when the {@code report} method is called.
 * </p>
 * 
 * @see ExpenseReportRequest
 */

public interface Observer {
     /**
     * Handles the given expense report request.
     * 
     * @param request the expense report request to process
     * @return {@code true} if the report was handled successfully, {@code false} otherwise
     */
     
    boolean report(ExpenseReportRequest request);
}
