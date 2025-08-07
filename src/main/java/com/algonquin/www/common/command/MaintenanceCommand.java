package com.algonquin.www.common.command;

/**
 * Represents a command for performing a maintenance-related action.
 * <p>
 * This interface defines a single method {@code execute} which
 * encapsulates the execution of a maintenance operation.
 * </p>
 * 
 * Implementing classes should provide the specific maintenance logic
 * inside the {@code execute} method.
 * 
 * Example usage:
 * <pre>
 * MaintenanceCommand command = new CleanVehicleCommand();
 * command.execute();
 * </pre>
 * 
 * @author 
 */

public interface MaintenanceCommand {
    
    /**
     * Executes the maintenance command.
     * Implementations should define the specific maintenance action to perform.
     */
    
    void execute();
}