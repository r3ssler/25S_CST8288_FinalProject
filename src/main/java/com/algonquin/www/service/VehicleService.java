package com.algonquin.www.service;

import com.algonquin.www.common.factory.ComponentFactory;
import com.algonquin.www.common.factory.VehicleFactory;
import com.algonquin.www.dao.ComponentDAO;
import com.algonquin.www.dao.VehicleDAO;
import com.algonquin.www.dao.impl.ComponentDAOImpl;
import com.algonquin.www.dao.impl.VehicleDAOImpl;
import com.algonquin.www.domain.ComponentDTO;
import com.algonquin.www.domain.VehicleDTO;
import com.algonquin.www.model.RegisterVehicleRequest;

import java.util.List;


public class VehicleService {

    private VehicleDAO vehicleDAO;

    private ComponentDAO componentDAO;

    public VehicleService() {
        vehicleDAO =  new VehicleDAOImpl();
        componentDAO = new ComponentDAOImpl();
    }

    public boolean registerVehicle(RegisterVehicleRequest request) {
        if (!vehicleDAO.searchByVehicleNumber(request.getVehicleNumber()).isEmpty()) {
            return true;
        }
        VehicleDTO vehicle = VehicleFactory.createVehicle(request.getVehicleNumber(), request.getVehicleType(), request.getRoute());
        List<ComponentDTO> components = ComponentFactory.createComponentsForVehicle(vehicle);
        vehicleDAO.addVehicle(vehicle);
        componentDAO.addComponents(components);
        return true;
    }

    public List<VehicleDTO> search(String vehicleNumber) {
        return vehicleDAO.search(vehicleNumber);
    }

    public List<ComponentDTO> componentDetail(String vehicleNumber) {
        return componentDAO.findByVehicle(vehicleNumber);
    }
}
