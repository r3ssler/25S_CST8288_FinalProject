package com.algonquin.www.service;

import com.algonquin.www.common.observer.impl.ExpenseReportSubject;
import com.algonquin.www.common.observer.impl.FuelExpenseObserver;
import com.algonquin.www.common.observer.impl.MaintenanceExpenseObserver;
import com.algonquin.www.common.strategy.ExpenseCalculator;
import com.algonquin.www.common.strategy.impl.BusExpenseStrategy;
import com.algonquin.www.common.strategy.impl.LightRailExpenseStrategy;
import com.algonquin.www.common.strategy.impl.MaintenanceExpenseStrategy;
import com.algonquin.www.common.strategy.impl.TrainExpenseStrategy;
import com.algonquin.www.dao.ComponentDAO;
import com.algonquin.www.dao.ExpenseRecordDAO;
import com.algonquin.www.dao.impl.ComponentDAOImpl;
import com.algonquin.www.dao.impl.ExpenseRecordDAOImpl;
import com.algonquin.www.domain.ExpenseRecordDTO;
import com.algonquin.www.model.EfficiencyMetricsResponse;
import com.algonquin.www.model.ExpenseRecordSearchRequest;
import com.algonquin.www.model.ExpenseReportRequest;

import java.util.List;
/**
 * Service class for managing usage and expense related operations.
 * <p>
 * Provides functionality to calculate efficiency metrics, search expense records,
 * and report new expense records using Observer and Strategy design patterns.
 * </p>
 */

public class UsageService {

    private ExpenseRecordDAO expenseRecordDAO;

    private ComponentDAO componentDAO;

    private ExpenseReportSubject subject;
     /**
     * Constructs a new UsageService instance.
     * <p>
     * Initializes DAOs and sets up observers for expense reporting.
     * </p>
     */

    public UsageService() {
        expenseRecordDAO = new ExpenseRecordDAOImpl();
        componentDAO = new ComponentDAOImpl();
        subject = new ExpenseReportSubject();

        FuelExpenseObserver fuelExpenseObserver = new FuelExpenseObserver(expenseRecordDAO);
        MaintenanceExpenseObserver maintenanceExpenseObserver = new MaintenanceExpenseObserver(expenseRecordDAO, componentDAO);
        subject.attach(fuelExpenseObserver);
        subject.attach(maintenanceExpenseObserver);
    }
    
      /**
     * Calculates efficiency metrics for different vehicle types and maintenance.
     * <p>
     * Uses the Strategy pattern to calculate expenses for buses, light rails, trains,
     * and maintenance costs, aggregating the results into an {@link EfficiencyMetricsResponse}.
     * </p>
     *
     * @return an {@link EfficiencyMetricsResponse} containing calculated metrics
     */

    public EfficiencyMetricsResponse efficiencyMetrics() {
        ExpenseCalculator calculator = new ExpenseCalculator();

        List<ExpenseRecordDTO> records = expenseRecordDAO.getAllExpenseRecords();

        EfficiencyMetricsResponse response = new EfficiencyMetricsResponse();

        calculator.setStrategy(new BusExpenseStrategy());
        response.setBus(calculator.calculate(records));

        calculator.setStrategy(new LightRailExpenseStrategy());
        response.setLightRail(calculator.calculate(records));

        calculator.setStrategy(new TrainExpenseStrategy());
        response.setTrain(calculator.calculate(records));

        calculator.setStrategy(new MaintenanceExpenseStrategy());
        response.setMaintenance(calculator.calculate(records));
        return response;
    }
    
     /**
     * Searches expense records based on criteria in the request.
     *
     * @param request the {@link ExpenseRecordSearchRequest} containing search parameters
     * @return a list of matching {@link ExpenseRecordDTO} objects
     */

    public List<ExpenseRecordDTO> expenseRecordSearch(ExpenseRecordSearchRequest request) {
        return expenseRecordDAO.expenseRecordSearch(request);
    }
    
     /**
     * Reports a new expense record by notifying registered observers.
     * <p>
     * The method triggers the Observer pattern notification by setting the
     * {@link ExpenseReportRequest} on the subject.
     * </p>
     *
     * @param request the {@link ExpenseReportRequest} containing expense details
     * @return always returns true to indicate the report was accepted
     */

    public boolean report(ExpenseReportRequest request) {
        subject.setRequest(request);
        return true;
    }
}
