
package com.algonquin.www.common.strategy.impl;

import com.algonquin.www.common.constants.UsageEventTypes;
import com.algonquin.www.common.strategy.ExpenseCalculationStrategy;
import com.algonquin.www.domain.ExpenseRecordDTO;

import java.util.List;

/**
 * Strategy implementation for calculating the total expense associated with
 * Light Rail vehicle usage.
 * <p>
 * This class filters a list of {@link ExpenseRecordDTO} objects to include only those
 * with a usage type equal to {@code UsageEventTypes.LIGHT_RAIL}, and calculates
 * the total sum of their expense values.
 * </p>
 *
 * <pre>
 * Example usage:
 * ExpenseCalculationStrategy strategy = new LightRailExpenseStrategy();
 * double lightRailExpenses = strategy.calculate(allRecords);
 * </pre>
 *
 * @see ExpenseCalculationStrategy
 * @see ExpenseRecordDTO
 * @see UsageEventTypes
 */

public class LightRailExpenseStrategy implements ExpenseCalculationStrategy {
    
    /**
     * Calculates the total expense for Light Rail-related usage events.
     *
     * @param records the list of expense records to evaluate
     * @return the total expense for Light Rail usage events
     */
    
    @Override
    public double calculate(List<ExpenseRecordDTO> records) {
        return records.stream()
                .filter(r -> UsageEventTypes.LIGHT_RAIL.equalsIgnoreCase(r.getType()))
                .mapToDouble(ExpenseRecordDTO::getExpense)
                .sum();
    }
}