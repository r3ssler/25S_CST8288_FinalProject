package com.algonquin.www.common.strategy;

import com.algonquin.www.domain.ExpenseRecordDTO;

import java.util.List;

/**
 * Context class in the Strategy design pattern used to calculate expenses
 * using a configurable {@link ExpenseCalculationStrategy}.
 * <p>
 * This class allows for dynamic selection of an expense calculation strategy
 * (e.g., fuel cost, maintenance cost, or average cost) at runtime.
 * </p>
 *
 * <pre>
 * Usage example:
 * ExpenseCalculator calculator = new ExpenseCalculator();
 * calculator.setStrategy(new FuelExpenseCalculationStrategy());
 * double fuelCost = calculator.calculate(fuelExpenseRecords);
 * </pre>
 *
 * @see ExpenseCalculationStrategy
 * @see ExpenseRecordDTO
 */

public class ExpenseCalculator {
     /**
     * The strategy used to calculate expenses.
     */
    private ExpenseCalculationStrategy strategy;
    /**
     * Sets the strategy to be used for expense calculation.
     *
     * @param strategy the {@link ExpenseCalculationStrategy} to apply
     */
    
    public void setStrategy(ExpenseCalculationStrategy strategy) {
        this.strategy = strategy;
    }
    
     /**
     * Calculates expenses using the current strategy and a list of expense records.
     *
     * @param records the list of {@link ExpenseRecordDTO} records to process
     * @return the calculated expense value
     * @throws IllegalStateException if no strategy has been set
     */

    public double calculate(List<ExpenseRecordDTO> records) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy not set");
        }
        return strategy.calculate(records);
    }
}