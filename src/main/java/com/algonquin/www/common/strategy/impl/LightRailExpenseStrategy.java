
package com.algonquin.www.common.strategy.impl;

import com.algonquin.www.common.constants.UsageEventTypes;
import com.algonquin.www.common.strategy.ExpenseCalculationStrategy;
import com.algonquin.www.domain.ExpenseRecordDTO;

import java.util.List;

public class LightRailExpenseStrategy implements ExpenseCalculationStrategy {
    
    @Override
    public double calculate(List<ExpenseRecordDTO> records) {
        return records.stream()
                .filter(r -> UsageEventTypes.LIGHT_RAIL.equalsIgnoreCase(r.getType()))
                .mapToDouble(ExpenseRecordDTO::getExpense)
                .sum();
    }
}