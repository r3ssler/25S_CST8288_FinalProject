package com.algonquin.www.common.observer;

public interface Subject {
    
    void attach(Observer o);
    
    void detach(Observer o);
    
    void notifyObservers();
}
