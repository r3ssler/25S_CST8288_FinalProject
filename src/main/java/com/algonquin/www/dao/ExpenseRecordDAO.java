package com.algonquin.www.dao;

import com.algonquin.www.domain.ExpenseRecordDTO;
import com.algonquin.www.model.ExpenseRecordSearchRequest;

import java.sql.Connection;
import java.util.List;

public interface ExpenseRecordDAO {
    
    List<ExpenseRecordDTO> expenseRecordSearch(ExpenseRecordSearchRequest request);
    
    int count(ExpenseRecordSearchRequest request);

    void addExpenseRecord(ExpenseRecordDTO expenseRecordDTO);
    
    List<ExpenseRecordDTO> getAllExpenseRecords();

}
