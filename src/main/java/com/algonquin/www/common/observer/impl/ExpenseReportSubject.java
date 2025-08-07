package com.algonquin.www.common.observer.impl;

import com.algonquin.www.common.observer.Observer;
import com.algonquin.www.common.observer.Subject;
import com.algonquin.www.model.ExpenseReportRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete implementation of the {@link Subject} interface for managing observers
 * interested in {@link ExpenseReportRequest} updates.
 * <p>
 * Maintains a list of observers and notifies them whenever a new expense report request
 * is set.
 * </p>
 * 
 * <p>
 * Usage example:
 * <pre>
 * ExpenseReportSubject subject = new ExpenseReportSubject();
 * subject.attach(new SomeObserverImplementation());
 * subject.setRequest(new ExpenseReportRequest(...));
 * </pre>
 * </p>
 * 
 * @see Subject
 * @see Observer
 * @see ExpenseReportRequest
 */

public class ExpenseReportSubject implements Subject {

    private List<Observer> observers;
    private ExpenseReportRequest request;
    
     /**
     * Constructs a new {@code ExpenseReportSubject} with an empty observer list.
     */
 
    public ExpenseReportSubject() {
        observers = new ArrayList<>();
    }
    
    
    /**
     * Attaches an observer to this subject.
     *
     * @param o the observer to be attached
     */

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }
    
     /**
     * Detaches an observer from this subject.
     *
     * @param o the observer to be detached
     */

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }
    
    /**
     * Notifies all attached observers by calling their {@code report} method
     * with the current expense report request.
     */
    
    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.report(request);
        }
    }
     /**
     * Sets the current {@link ExpenseReportRequest} and notifies all observers
     * about this update.
     *
     * @param request the expense report request to set
     */
   
    public void setRequest(ExpenseReportRequest request) {
        this.request = request;
        notifyObservers();
    }
}
