package com.algonquin.www.common.command.impl;
import com.algonquin.www.common.command.MaintenanceCommand;
import com.algonquin.www.dao.ComponentDAO;
import com.algonquin.www.dao.VehicleDAO;
import com.algonquin.www.domain.ComponentDTO;
import com.algonquin.www.domain.VehicleDTO;

import java.util.List;

public class AutoCheckMaintenanceCommand implements MaintenanceCommand {
    private static final double MAINTENANCE_THRESHOLD = 1000.0;

    private final VehicleDAO vehicleDAO;
    private final ComponentDAO componentDAO;
    private final String vehicleNumber;
   
    public AutoCheckMaintenanceCommand(VehicleDAO vehicleDAO, ComponentDAO componentDAO, String vehicleNumber) {
        this.vehicleDAO = vehicleDAO;
        this.componentDAO = componentDAO;
        this.vehicleNumber = vehicleNumber;
    }

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
