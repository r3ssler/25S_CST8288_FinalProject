
package com.algonquin.www.common.observer.impl;

import com.algonquin.www.common.constants.UsageEventTypes;
import com.algonquin.www.common.observer.Observer;
import com.algonquin.www.dao.ComponentDAO;
import com.algonquin.www.dao.ExpenseRecordDAO;
import com.algonquin.www.domain.ComponentDTO;
import com.algonquin.www.domain.ExpenseRecordDTO;
import com.algonquin.www.model.ExpenseReportRequest;

import java.util.List;


/**
 * Concrete implementation of the {@link Observer} interface that handles maintenance-related
 * expense reports. This observer performs two main actions:
 * <ul>
 *     <li>Updates the used hours of all components associated with the vehicle undergoing maintenance.</li>
 *     <li>Persists a maintenance expense record to the database.</li>
 * </ul>
 *
 * <p>
 * The observer is only triggered for reports with the type {@code "maintenance"} (as defined in
 * {@link UsageEventTypes#MAINTENANCE}). Other report types are ignored.
 * </p>
 *
 * <pre>
 * Example usage:
 * ExpenseReportSubject subject = new ExpenseReportSubject();
 * subject.attach(new MaintenanceExpenseObserver(expenseRecordDAO, componentDAO));
 * </pre>
 *
 * @see Observer
 * @see ExpenseReportRequest
 * @see ExpenseRecordDAO
 * @see ComponentDAO
 */

public class MaintenanceExpenseObserver implements Observer {

    private ExpenseRecordDAO expenseRecordDAO;
    private ComponentDAO componentDAO;
    
    /**
     * Constructs a {@code MaintenanceExpenseObserver} with the specified DAOs for
     * recording expenses and updating component data.
     *
     * @param expenseRecordDAO DAO used to store maintenance expense records
     * @param componentDAO     DAO used to fetch and update vehicle components
     */
    
    public MaintenanceExpenseObserver(ExpenseRecordDAO expenseRecordDAO, ComponentDAO componentDAO) {
        this.expenseRecordDAO = expenseRecordDAO;
        this.componentDAO = componentDAO;
    }
    
     /**
     * Handles an {@link ExpenseReportRequest} related to vehicle maintenance. If the request type
     * is not "maintenance", the method exits early. Otherwise, it:
     * <ol>
     *     <li>Retrieves components for the vehicle and updates their used hours based on mileage difference.</li>
     *     <li>Saves an {@link ExpenseRecordDTO} for the maintenance event.</li>
     * </ol>
     *
     * @param request the maintenance expense report to process
     * @return {@code true} if processing completes successfully, even if no components exist
     */
    
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
