package com.algonquin.www.service;

import com.algonquin.www.common.command.MaintenanceCommand;
import com.algonquin.www.common.command.MaintenanceInvoker;
import com.algonquin.www.common.command.impl.AutoCheckMaintenanceCommand;
import com.algonquin.www.common.command.impl.ForceMaintenanceCommand;
import com.algonquin.www.dao.ComponentDAO;
import com.algonquin.www.dao.VehicleDAO;
import com.algonquin.www.dao.impl.ComponentDAOImpl;
import com.algonquin.www.dao.impl.VehicleDAOImpl;
import com.algonquin.www.domain.VehicleDTO;


import java.util.List;

/**
 * Service class responsible for vehicle maintenance operations.
 * <p>
 * Provides methods to search vehicles and trigger maintenance-related commands
 * such as automatic maintenance checks and forced maintenance actions.
 * </p>
 */

public class MaintenanceService {

    private VehicleDAO vehicleDAO;

    private ComponentDAO componentDAO;
    
    /**
     * Constructs a new MaintenanceService instance,
     * initializing DAO implementations.
     */

    public MaintenanceService() {
        vehicleDAO = new VehicleDAOImpl();
        componentDAO = new ComponentDAOImpl();
    }
    
    /**
     * Searches for vehicles by their vehicle number.
     *
     * @param vehicleNumber the vehicle number to search for
     * @return a list of matching {@link VehicleDTO} objects; empty if none found
     */

    public List<VehicleDTO> search(String vehicleNumber) {
        return vehicleDAO.search(vehicleNumber);
    }
    
     /**
     * Executes an automatic maintenance check on the specified vehicle.
     * <p>
     * This method creates and executes an {@link AutoCheckMaintenanceCommand}
     * via the {@link MaintenanceInvoker}.
     * </p>
     *
     * @param vehicleNumber the vehicle number to perform the maintenance check on
     * @return true if the command was executed successfully (always returns true)
     */

    public boolean autoCheckMaintenance(String vehicleNumber) {
        MaintenanceCommand autoCheck = new AutoCheckMaintenanceCommand(vehicleDAO, componentDAO, vehicleNumber);
        new MaintenanceInvoker(autoCheck).execute();
        return true;
    }
    
     /**
     * Forces maintenance action on the specified vehicle.
     * <p>
     * This method creates and executes a {@link ForceMaintenanceCommand}
     * via the {@link MaintenanceInvoker}.
     * </p>
     *
     * @param vehicleNumber the vehicle number to force maintenance on
     * @return true if the command was executed successfully (always returns true)
     */

    public boolean forceMaintenance(String vehicleNumber) {
        MaintenanceCommand force = new ForceMaintenanceCommand(vehicleDAO, vehicleNumber);
        new MaintenanceInvoker(force).execute();
        return true;
    }
}
