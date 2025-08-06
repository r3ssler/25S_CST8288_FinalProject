
package com.algonquin.www.common.observer.impl;

import com.algonquin.www.common.constants.UsageEventTypes;
import com.algonquin.www.common.observer.Observer;
import com.algonquin.www.dao.ExpenseRecordDAO;
import com.algonquin.www.domain.ExpenseRecordDTO;
import com.algonquin.www.model.ExpenseReportRequest;


public class FuelExpenseObserver implements Observer {

    private ExpenseRecordDAO expenseRecordDAO;
    
    public FuelExpenseObserver(ExpenseRecordDAO expenseRecordDAO) {
        this.expenseRecordDAO = expenseRecordDAO;
    }
    
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
