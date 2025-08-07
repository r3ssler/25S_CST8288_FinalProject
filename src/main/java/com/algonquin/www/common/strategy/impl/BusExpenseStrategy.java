
package com.algonquin.www.common.strategy.impl;

import com.algonquin.www.common.constants.UsageEventTypes;
import com.algonquin.www.common.strategy.ExpenseCalculationStrategy;
import com.algonquin.www.domain.ExpenseRecordDTO;

import java.util.List;
/**
 * Strategy implementation that calculates the total expense specifically
 * related to bus usage events.
 * <p>
 * This class filters the list of {@link ExpenseRecordDTO} objects to include
 * only those with the type matching {@code UsageEventTypes.BUS}, and then
 * sums their expense values.
 * </p>
 *
 * <pre>
 * Example usage:
 * ExpenseCalculationStrategy strategy = new BusExpenseStrategy();
 * double busExpenses = strategy.calculate(allRecords);
 * </pre>
 *
 * @see ExpenseCalculationStrategy
 * @see ExpenseRecordDTO
 * @see UsageEventTypes
 */

public class BusExpenseStrategy implements ExpenseCalculationStrategy {
    
     /**
     * Calculates the total expense for records related to bus usage.
     *
     * @param records the list of expense records to evaluate
     * @return the total expense for bus usage events
     */
    
    @Override
    public double calculate(List<ExpenseRecordDTO> records) {
        return records.stream()
                .filter(r -> UsageEventTypes.BUS.equalsIgnoreCase(r.getType()))
                .mapToDouble(ExpenseRecordDTO::getExpense)
                .sum();
    }
}