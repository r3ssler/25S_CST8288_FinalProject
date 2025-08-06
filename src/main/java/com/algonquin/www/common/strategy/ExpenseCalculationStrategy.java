package com.algonquin.www.common.strategy;

import com.algonquin.www.domain.ExpenseRecordDTO;

import java.util.List;

public interface ExpenseCalculationStrategy {
    
    double calculate(List<ExpenseRecordDTO> records);
}
