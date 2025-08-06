package com.algonquin.www.common.observer.impl;

import com.algonquin.www.common.observer.Observer;
import com.algonquin.www.common.observer.Subject;
import com.algonquin.www.model.ExpenseReportRequest;

import java.util.ArrayList;
import java.util.List;

public class ExpenseReportSubject implements Subject {

    private List<Observer> observers;
    private ExpenseReportRequest request;
 
    public ExpenseReportSubject() {
        observers = new ArrayList<>();
    }

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }
    
    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.report(request);
        }
    }
   
    public void setRequest(ExpenseReportRequest request) {
        this.request = request;
        notifyObservers();
    }
}
