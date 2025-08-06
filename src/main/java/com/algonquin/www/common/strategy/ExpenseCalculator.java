package com.algonquin.www.common.strategy;

import com.algonquin.www.domain.ExpenseRecordDTO;

import java.util.List;

public class ExpenseCalculator {
    private ExpenseCalculationStrategy strategy;
    
    public void setStrategy(ExpenseCalculationStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculate(List<ExpenseRecordDTO> records) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy not set");
        }
        return strategy.calculate(records);
    }
}