
package com.algonquin.www.common.command.impl;

import com.algonquin.www.common.command.MaintenanceCommand;
import com.algonquin.www.dao.VehicleDAO;
import com.algonquin.www.domain.VehicleDTO;

import java.util.List;

public class ForceMaintenanceCommand implements MaintenanceCommand {
    private final VehicleDAO vehicleDAO;
    private final String vehicleNumber;
   
    public ForceMaintenanceCommand(VehicleDAO vehicleDAO, String vehicleNumber) {
        this.vehicleDAO = vehicleDAO;
        this.vehicleNumber = vehicleNumber;
    }
    
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
