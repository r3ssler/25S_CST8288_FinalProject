
package com.algonquin.www.common.observer.impl;

import com.algonquin.www.common.constants.UsageEventTypes;
import com.algonquin.www.common.observer.Observer;
import com.algonquin.www.dao.ComponentDAO;
import com.algonquin.www.dao.ExpenseRecordDAO;
import com.algonquin.www.domain.ComponentDTO;
import com.algonquin.www.domain.ExpenseRecordDTO;
import com.algonquin.www.model.ExpenseReportRequest;

import java.util.List;

public class MaintenanceExpenseObserver implements Observer {

    private ExpenseRecordDAO expenseRecordDAO;
    private ComponentDAO componentDAO;
    
    public MaintenanceExpenseObserver(ExpenseRecordDAO expenseRecordDAO, ComponentDAO componentDAO) {
        this.expenseRecordDAO = expenseRecordDAO;
        this.componentDAO = componentDAO;
    }
    
    @Override
    public boolean report(ExpenseReportRequest request) {
        if (!request.getType().equals(UsageEventTypes.MAINTENANCE)) {
            return true;
        }

        List<ComponentDTO> components = componentDAO.findByVehicle(request.getVehicleNumber());
        if (components == null || components.isEmpty()) {
            return true;
        }

        double hours = Math.abs(request.getCurrentMile() - request.getLastMile()) / 60;
        for (ComponentDTO component : components) {
            component.setUsedHours(component.getUsedHours() + hours);
            componentDAO.updateComponent(component);
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
