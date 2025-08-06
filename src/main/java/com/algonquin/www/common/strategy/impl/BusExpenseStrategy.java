
package com.algonquin.www.common.strategy.impl;

import com.algonquin.www.common.constants.UsageEventTypes;
import com.algonquin.www.common.strategy.ExpenseCalculationStrategy;
import com.algonquin.www.domain.ExpenseRecordDTO;

import java.util.List;

public class BusExpenseStrategy implements ExpenseCalculationStrategy {
    
    @Override
    public double calculate(List<ExpenseRecordDTO> records) {
        return records.stream()
                .filter(r -> UsageEventTypes.BUS.equalsIgnoreCase(r.getType()))
                .mapToDouble(ExpenseRecordDTO::getExpense)
                .sum();
    }
}