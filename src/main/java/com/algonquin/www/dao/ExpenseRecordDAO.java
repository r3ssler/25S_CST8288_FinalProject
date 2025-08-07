package com.algonquin.www.dao;

import com.algonquin.www.domain.ExpenseRecordDTO;
import com.algonquin.www.model.ExpenseRecordSearchRequest;

import java.sql.Connection;
import java.util.List;

/**
 * Data Access Object (DAO) interface for managing ExpenseRecordDTO entities.
 * <p>
 * Provides methods to search, count, add, and retrieve expense records
 * related to vehicle usage and maintenance.
 * </p>
 * 
 * @author
 * @version 1.0
 * @since 2025-08-07
 */

public interface ExpenseRecordDAO {
    /**
     * Searches expense records based on criteria encapsulated in the given request object.
     *
     * @param request the search criteria for filtering expense records
     * @return a list of matching ExpenseRecordDTO objects
     */
    
    List<ExpenseRecordDTO> expenseRecordSearch(ExpenseRecordSearchRequest request);
    /**
     * Counts the total number of expense records matching the given search criteria.
     *
     * @param request the search criteria
     * @return the count of matching expense records
     */
    
    int count(ExpenseRecordSearchRequest request);
    /**
     * Adds a new expense record to the data store.
     *
     * @param expenseRecordDTO the expense record to add
     */

    void addExpenseRecord(ExpenseRecordDTO expenseRecordDTO);
    /**
     * Retrieves all expense records from the data store.
     *
     * @return a list of all ExpenseRecordDTO objects
     */
    
    List<ExpenseRecordDTO> getAllExpenseRecords();

}
