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

public class UsageService {

    private ExpenseRecordDAO expenseRecordDAO;

    private ComponentDAO componentDAO;

    private ExpenseReportSubject subject;

    public UsageService() {
        expenseRecordDAO = new ExpenseRecordDAOImpl();
        componentDAO = new ComponentDAOImpl();
        subject = new ExpenseReportSubject();

        FuelExpenseObserver fuelExpenseObserver = new FuelExpenseObserver(expenseRecordDAO);
        MaintenanceExpenseObserver maintenanceExpenseObserver = new MaintenanceExpenseObserver(expenseRecordDAO, componentDAO);
        subject.attach(fuelExpenseObserver);
        subject.attach(maintenanceExpenseObserver);
    }

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

    public List<ExpenseRecordDTO> expenseRecordSearch(ExpenseRecordSearchRequest request) {
        return expenseRecordDAO.expenseRecordSearch(request);
    }

    public boolean report(ExpenseReportRequest request) {
        subject.setRequest(request);
        return true;
    }
}
