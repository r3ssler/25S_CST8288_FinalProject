
package com.algonquin.www.common.command.impl;

import com.algonquin.www.common.command.MaintenanceCommand;
import com.algonquin.www.dao.VehicleDAO;
import com.algonquin.www.domain.VehicleDTO;

import java.util.List;

/**
 * Concrete implementation of {@link MaintenanceCommand} that forces a vehicle into maintenance status.
 * <p>
 * This command sets the status of the specified vehicle to "Maintenance" regardless of its current state.
 * </p>
 * 
 * <pre>
 * Example usage:
 * MaintenanceCommand command = new ForceMaintenanceCommand(vehicleDAO, "BUS123");
 * command.execute();
 * </pre>
 * 
 * This class follows the Command design pattern to encapsulate the action of forcing maintenance.
 * 
 * @see MaintenanceCommand
 * @see VehicleDAO
 */

public class ForceMaintenanceCommand implements MaintenanceCommand {
    private final VehicleDAO vehicleDAO;
    private final String vehicleNumber;
    
      /**
     * Constructs a new ForceMaintenanceCommand.
     * 
     * @param vehicleDAO    DAO to perform vehicle data operations
     * @param vehicleNumber the vehicle number to be set to maintenance
     */
   
    public ForceMaintenanceCommand(VehicleDAO vehicleDAO, String vehicleNumber) {
        this.vehicleDAO = vehicleDAO;
        this.vehicleNumber = vehicleNumber;
    }
    
    /**
     * Executes the command to force the vehicle into maintenance status.
     * <p>
     * Searches for the vehicle by its number and if found, sets its status to "Maintenance"
     * and updates it in the database. Logs success or error messages accordingly.
     * </p>
     */
    
    @Override
    public void execute() {
        List<VehicleDTO> vehicles = vehicleDAO.search(vehicleNumber);
        if (!vehicles.isEmpty()) {
            VehicleDTO vehicle = vehicles.get(0);
            vehicle.setStatus("Maintenance");
            vehicleDAO.updateVehicle(vehicle);
            System.out.println("Forced: Vehicle " + vehicleNumber + " set to Maintenance.");
        } else {
            System.err.println("Vehicle not found: " + vehicleNumber);
        }
    }
}
