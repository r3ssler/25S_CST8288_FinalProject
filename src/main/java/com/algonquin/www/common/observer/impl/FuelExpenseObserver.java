
package com.algonquin.www.common.observer.impl;

import com.algonquin.www.common.constants.UsageEventTypes;
import com.algonquin.www.common.observer.Observer;
import com.algonquin.www.dao.ExpenseRecordDAO;
import com.algonquin.www.domain.ExpenseRecordDTO;
import com.algonquin.www.model.ExpenseReportRequest;

/**
 * Concrete implementation of the {@link Observer} interface that handles fuel-related
 * expense reports. It filters out maintenance events and records other types
 * (e.g., bus, train, light rail usage) as fuel expenses.
 * 
 * <p>
 * This observer saves the report details to the database using {@link ExpenseRecordDAO}.
 * </p>
 *
 * <p><strong>Note:</strong> If the report is of type {@code maintenance}, it is ignored.</p>
 * 
 * <pre>
 * Example usage:
 * ExpenseReportSubject subject = new ExpenseReportSubject();
 * subject.attach(new FuelExpenseObserver(expenseRecordDAO));
 * </pre>
 *
 * @see Observer
 * @see ExpenseReportRequest
 * @see ExpenseRecordDAO
 */

public class FuelExpenseObserver implements Observer {

    private ExpenseRecordDAO expenseRecordDAO;
    /**
     * Constructs a {@code FuelExpenseObserver} with the given {@link ExpenseRecordDAO}.
     *
     * @param expenseRecordDAO DAO used to persist fuel expense records
     */
    
    public FuelExpenseObserver(ExpenseRecordDAO expenseRecordDAO) {
        this.expenseRecordDAO = expenseRecordDAO;
    }
    
    /**
     * Processes the incoming {@link ExpenseReportRequest}. If the request type is not
     * "maintenance", a new {@link ExpenseRecordDTO} is created and saved using the DAO.
     *
     * @param request the expense report request to process
     * @return {@code true} if the request was processed or ignored successfully
     */
    
    @Override
    public boolean report(ExpenseReportRequest request) {
        if (request.getType().equals(UsageEventTypes.MAINTENANCE)) {
            return true;
        }
        ExpenseRecordDTO record = new ExpenseRecordDTO();
        record.setVehicleNumber(request.getVehicleNumber());
        record.setType(request.getType());
        record.setExpense(request.getExpense());
        record.setUsageAmount(request.getExpense());
        record.setLastMile(record.getLastMile());
        record.setCurrentMile(record.getCurrentMile());
        expenseRecordDAO.addExpenseRecord(record);
        return true;
    }
}
