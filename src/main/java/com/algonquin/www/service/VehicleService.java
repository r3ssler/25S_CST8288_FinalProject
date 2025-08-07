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
/**
 * Service class to handle business logic related to vehicles and their components.
 * Acts as a bridge between the DAO layer and the presentation/controller .
 */


public class VehicleService {
     /**
     * DAO for vehicle-related database operations.
     */

    private VehicleDAO vehicleDAO;
     /**
     * DAO for component-related database operations.
     */

    private ComponentDAO componentDAO;
    
    /**
     * Constructs a new VehicleService instance.
     * Initializes DAO implementations for vehicles and components.
     */

    public VehicleService() {
        vehicleDAO =  new VehicleDAOImpl();
        componentDAO = new ComponentDAOImpl();
    }
     /**
     * Registers a new vehicle along with its components.
     * If a vehicle with the same vehicle number already exists, the registration is skipped.
     *
     * @param request the registration request containing vehicle details
     * @return {@code true} if the vehicle was successfully registered or already exists, {@code false} otherwise
     */

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
        /**
     * Searches for vehicles matching the given vehicle number.
     *
     * @param vehicleNumber the vehicle number to search for
     * @return a list of {@link VehicleDTO} matching the vehicle number; empty list if none found
     */


    public List<VehicleDTO> search(String vehicleNumber) {
        return vehicleDAO.search(vehicleNumber);
    }
    
    /**
     * Retrieves the list of components associated with the specified vehicle.
     *
     * @param vehicleNumber the vehicle number whose components are to be fetched
     * @return a list of {@link ComponentDTO} belonging to the vehicle; empty list if none found
     */

    public List<ComponentDTO> componentDetail(String vehicleNumber) {
        return componentDAO.findByVehicle(vehicleNumber);
    }

    public boolean update(VehicleDTO vehicle) {
        return vehicleDAO.updateVehicle(vehicle);
    }

}
