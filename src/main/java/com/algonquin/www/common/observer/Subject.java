package com.algonquin.www.common.observer;

/**
 * Represents the Subject in the Observer design pattern.
 * <p>
 * Defines methods to attach, detach, and notify observers.
 * </p>
 * 
 * @see Observer
 */

public interface Subject {
     /**
     * Attaches an observer to this subject.
     * 
     * @param o the observer to be attached
     */
    
    void attach(Observer o);
     /**
     * Detaches an observer from this subject.
     * 
     * @param o the observer to be detached
     */
    
    void detach(Observer o);
     /**
     * Notifies all attached observers of a change or event.
     */
    
    void notifyObservers();
}
