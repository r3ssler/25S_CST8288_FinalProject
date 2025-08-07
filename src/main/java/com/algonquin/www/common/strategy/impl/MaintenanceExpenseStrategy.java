package com.algonquin.www.common.strategy.impl;

import com.algonquin.www.common.constants.UsageEventTypes;
import com.algonquin.www.common.strategy.ExpenseCalculationStrategy;
import com.algonquin.www.domain.ExpenseRecordDTO;

import java.util.List;


/**
 * Strategy implementation for calculating total maintenance-related expenses.
 * <p>
 * This class filters a list of {@link ExpenseRecordDTO} instances to include only those
 * where the type is {@code UsageEventTypes.MAINTENANCE}, and computes the total sum of
 * their expense values.
 * </p>
 *
 * <pre>
 * Example usage:
 * ExpenseCalculationStrategy strategy = new MaintenanceExpenseStrategy();
 * double maintenanceCost = strategy.calculate(expenseRecords);
 * </pre>
 *
 * @see ExpenseCalculationStrategy
 * @see ExpenseRecordDTO
 * @see UsageEventTypes
 */

public class MaintenanceExpenseStrategy implements ExpenseCalculationStrategy {
     /**
     * Calculates the total maintenance expense from the given list of records.
     *
     * @param records the list of expense records to process
     * @return the total maintenance expense
     */
    @Override
    public double calculate(List<ExpenseRecordDTO> records) {
        return records.stream()
                .filter(r -> UsageEventTypes.MAINTENANCE.equalsIgnoreCase(r.getType()))
                .mapToDouble(ExpenseRecordDTO::getExpense)
                .sum();
    }
}