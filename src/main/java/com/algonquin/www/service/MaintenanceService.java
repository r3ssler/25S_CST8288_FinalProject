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

public class MaintenanceService {

    private VehicleDAO vehicleDAO;

    private ComponentDAO componentDAO;

    public MaintenanceService() {
        vehicleDAO = new VehicleDAOImpl();
        componentDAO = new ComponentDAOImpl();
    }

    public List<VehicleDTO> search(String vehicleNumber) {
        return vehicleDAO.search(vehicleNumber);
    }

    public boolean autoCheckMaintenance(String vehicleNumber) {
        MaintenanceCommand autoCheck = new AutoCheckMaintenanceCommand(vehicleDAO, componentDAO, vehicleNumber);
        new MaintenanceInvoker(autoCheck).execute();
        return true;
    }

    public boolean forceMaintenance(String vehicleNumber) {
        MaintenanceCommand force = new ForceMaintenanceCommand(vehicleDAO, vehicleNumber);
        new MaintenanceInvoker(force).execute();
        return true;
    }
}
