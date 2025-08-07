package com.algonquin.www.common.strategy;

import com.algonquin.www.domain.ExpenseRecordDTO;

import java.util.List;

/**
 * Strategy interface for calculating expenses based on a list of {@link ExpenseRecordDTO} records.
 * <p>
 * This interface is part of the Strategy design pattern and allows different algorithms for
 * expense calculation (e.g., total fuel cost, maintenance cost, or average cost) to be implemented
 * and used interchangeably.
 * </p>
 *
 * <p>
 * Example implementations may include:
 * <ul>
 *   <li>FuelExpenseCalculationStrategy</li>
 *   <li>MaintenanceExpenseCalculationStrategy</li>
 *   <li>AverageExpensePerMileStrategy</li>
 * </ul>
 * </p>
 *
 * <pre>
 * Usage example:
 * ExpenseCalculationStrategy strategy = new FuelExpenseCalculationStrategy();
 * double totalFuelExpense = strategy.calculate(fuelExpenseRecords);
 * </pre>
 *
 * @see ExpenseRecordDTO
 */

public interface ExpenseCalculationStrategy {
    /**
     * Calculates an expense value from the provided list of expense records.
     *
     * @param records the list of expense records to be processed
     * @return the computed expense value (e.g., total or average)
     */
    
    double calculate(List<ExpenseRecordDTO> records);
}
