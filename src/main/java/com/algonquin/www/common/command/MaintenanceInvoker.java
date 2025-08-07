package com.algonquin.www.common.command;

/**
 * Invoker class that triggers the execution of a {@link MaintenanceCommand}.
 * <p>
 * This class holds a reference to a {@code MaintenanceCommand} and
 * delegates the execution to that command when the {@code execute()} method is called.
 * </p>
 * 
 * Example usage:
 * <pre>
 * MaintenanceCommand command = new CleanVehicleCommand();
 * MaintenanceInvoker invoker = new MaintenanceInvoker(command);
 * invoker.execute();
 * </pre>
 * 
 * This class is typically used in the Command design pattern to decouple
 * the request sender from the request handler.
 * 
 * @author 
 */


public class MaintenanceInvoker {
     /** The maintenance command to be executed */
    private final MaintenanceCommand command;
   
    
    /**
     * Constructs a new {@code MaintenanceInvoker} with the specified command.
     *
     * @param command the maintenance command to execute
     */
    
    public MaintenanceInvoker(MaintenanceCommand command) {
        this.command = command;
    }
    
    
     /**
     * Executes the encapsulated maintenance command.
     */
    
    public void execute() {
        command.execute();
    }
}
