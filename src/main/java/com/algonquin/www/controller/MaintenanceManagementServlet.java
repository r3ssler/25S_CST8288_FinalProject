package com.algonquin.www.controller;

import com.algonquin.www.domain.ComponentDTO;
import com.algonquin.www.domain.VehicleDTO;
import com.algonquin.www.service.MaintenanceService;
import com.algonquin.www.service.VehicleService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * Servlet handling maintenance management operations for vehicles.
 * <p>
 * Supports displaying a maintenance dashboard, viewing component details,
 * triggering automatic maintenance checks, and forcing maintenance status updates.
 * </p>
 *
 * <p>Handles the following request paths:</p>
 * <ul>
 *     <li>GET /dashboard - Displays the maintenance dashboard with a list of vehicles.</li>
 *     <li>GET /components - Displays component details for a given vehicle.</li>
 *     <li>POST /auto - Initiates an automatic maintenance check for a vehicle.</li>
 *     <li>POST /force - Forces a vehicle into maintenance status.</li>
 * </ul>
 *
 * <p>Request parameter "vehicleNumber" is expected for all actions.</p>
 *
 * <pre>
 * Example usage:
 * GET /maintenance/dashboard?vehicleNumber=123
 * POST /maintenance/auto with parameter vehicleNumber=123
 * </pre>
 *
 * @author
 * @version 1.0
 * @since 2025-08-07
 */

public class MaintenanceManagementServlet extends HttpServlet {

    private MaintenanceService maintenanceService;
    private VehicleService vehicleService;
    
    
    /**
     * Initializes the servlet and its services.
     */
    
    @Override
    public void init() {
        maintenanceService = new MaintenanceService();
        vehicleService = new VehicleService();
    }
    
    /**
     * Handles HTTP GET requests for maintenance dashboard and component details.
     *
     * @param req  the HTTP request
     * @param resp the HTTP response
     * @throws IOException if an input or output error occurs
     */
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getPathInfo();
        switch (action) {
            case "/dashboard":
                dashboard(req, resp);
                break;
            case "/components":
                components(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
    
     /**
     * Handles HTTP POST requests for triggering maintenance operations.
     *
     * @param req  the HTTP request
     * @param resp the HTTP response
     * @throws IOException if an input or output error occurs
     */
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getPathInfo();
        switch (action) {
            case "/auto":
                autoMaintenanceCheck(req, resp);
                break;
            case "/force":
                forceMaintenance(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
    
     /**
     * Processes the maintenance dashboard view by retrieving a list of vehicles.
     *
     * @param req  the HTTP request
     * @param resp the HTTP response
     * @throws IOException if forwarding the request fails
     */
    
    private void dashboard(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<VehicleDTO> data = maintenanceService.search(req.getParameter("vehicleNumber"));
        req.setAttribute("maintenanceList", data);
        try {
            req.getRequestDispatcher("/jsp/maintenance-dashboard.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
    
    
    /**
     * Retrieves and forwards the component details of a specific vehicle.
     *
     * @param req  the HTTP request
     * @param resp the HTTP response
     * @throws IOException if forwarding the request fails
     */

    private void components(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<ComponentDTO> data = vehicleService.componentDetail(req.getParameter("vehicleNumber"));
        req.setAttribute("componentList", data);
        try {
            req.getRequestDispatcher("/jsp/component.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }

    }
    
    /**
     * Triggers an automatic maintenance check on the vehicle specified.
     *
     * @param req  the HTTP request
     * @param resp the HTTP response
     */

    private void autoMaintenanceCheck(HttpServletRequest req, HttpServletResponse resp) {
        maintenanceService.autoCheckMaintenance(req.getParameter("vehicleNumber"));
        resp.setStatus(HttpServletResponse.SC_OK);
    }
    
    
      /**
     * Forces a vehicle into maintenance status.
     *
     * @param req  the HTTP request
     * @param resp the HTTP response
     */

    private void forceMaintenance(HttpServletRequest req, HttpServletResponse resp) {
        maintenanceService.forceMaintenance(req.getParameter("vehicleNumber"));
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
