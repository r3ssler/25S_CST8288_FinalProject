package com.algonquin.www.common.command.impl;
import com.algonquin.www.common.command.MaintenanceCommand;
import com.algonquin.www.dao.ComponentDAO;
import com.algonquin.www.dao.VehicleDAO;
import com.algonquin.www.domain.ComponentDTO;
import com.algonquin.www.domain.VehicleDTO;

import java.util.List;


/**
 * Concrete implementation of {@link MaintenanceCommand} that performs an automatic
 * maintenance check on a vehicle based on component usage hours.
 * <p>
 * This command queries components associated with a given vehicle number and checks
 * if any component's used hours exceed a defined maintenance threshold. If so, it updates
 * the vehicle's status to "Maintenance".
 * </p>
 * 
 * <p>Threshold for maintenance is defined by {@link #MAINTENANCE_THRESHOLD} (default 1000 hours).</p>
 * 
 * <pre>
 * Example usage:
 * MaintenanceCommand command = new AutoCheckMaintenanceCommand(vehicleDAO, componentDAO, "BUS123");
 * command.execute();
 * </pre>
 * 
 * This class follows the Command design pattern and encapsulates the maintenance check logic.
 * 
 * @see MaintenanceCommand
 * @see VehicleDAO
 * @see ComponentDAO
 */

public class AutoCheckMaintenanceCommand implements MaintenanceCommand {
    /** The usage hour threshold to trigger maintenance */
    private static final double MAINTENANCE_THRESHOLD = 1000.0;

    private final VehicleDAO vehicleDAO;
    private final ComponentDAO componentDAO;
    private final String vehicleNumber;
    
     /**
     * Constructs a new AutoCheckMaintenanceCommand.
     * 
     * @param vehicleDAO    DAO to perform vehicle data operations
     * @param componentDAO  DAO to perform component data operations
     * @param vehicleNumber the vehicle number to check
     */
   
    public AutoCheckMaintenanceCommand(VehicleDAO vehicleDAO, ComponentDAO componentDAO, String vehicleNumber) {
        this.vehicleDAO = vehicleDAO;
        this.componentDAO = componentDAO;
        this.vehicleNumber = vehicleNumber;
    }
    /**
     * Executes the maintenance check.
     * <p>
     * Retrieves all components for the specified vehicle and checks if any component has
     * usage hours greater than or equal to the maintenance threshold. If true, updates the vehicle's
     * status to "Maintenance" using {@link VehicleDAO}.
     * </p>
     */
     
    @Override
    public void execute() {
        List<ComponentDTO> components = componentDAO.findByVehicle(vehicleNumber);

        boolean needsMaintenance = components.stream()
                .anyMatch(c -> c.getUsedHours() >= MAINTENANCE_THRESHOLD);

        if (needsMaintenance) {
            List<VehicleDTO> vehicles = vehicleDAO.search(vehicleNumber);
            if (!vehicles.isEmpty()) {
                VehicleDTO vehicle = vehicles.get(0);
                vehicle.setStatus("Maintenance");
                vehicleDAO.updateVehicle(vehicle);
            }
        }
    }
}
