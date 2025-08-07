
package com.algonquin.www.controller;

import com.algonquin.www.domain.UserDTO;
import com.algonquin.www.domain.VehicleDTO;
import com.algonquin.www.domain.VehicleLogDTO;
import com.algonquin.www.model.LogUploadRequest;
import com.algonquin.www.model.RegisterVehicleRequest;
import com.algonquin.www.service.VehicleLogService;
import com.algonquin.www.service.VehicleService;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * Servlet responsible for managing vehicle-related operations, including vehicle registration,
 * vehicle logs upload, and listing vehicles or logs.
 * <p>
 * Supported HTTP methods and paths:
 * </p>
 * <ul>
 *   <li>GET /register - Displays the vehicle registration page.</li>
 *   <li>GET /logUpload - Displays the vehicle log upload page.</li>
 *   <li>GET /log - Shows logs for a specific vehicle.</li>
 *   <li>GET /list - Lists vehicles based on an optional vehicle number search parameter.</li>
 *   <li>POST /register - Processes vehicle registration requests.</li>
 *   <li>POST /log - Processes vehicle log uploads.</li>
 * </ul>
 * 
 * <p>
 * Usage examples:
 * <ul>
 *   <li>GET /vehicle/register</li>
 *   <li>POST /vehicle/register with parameters vehicleType, vehicleNumber, route</li>
 *   <li>GET /vehicle/log?vehicleNumber=1234</li>
 *   <li>POST /vehicle/log with parameters vehicleNumber, eventType, location</li>
 * </ul>
 * </p>
 * 
 * <p>This servlet delegates business logic to {@link VehicleService} and {@link VehicleLogService}.</p>
 * 
 * @author
 * @version 1.0
 * @since 2025-08-07
 */

public class VehicleManagementServlet extends HttpServlet {

    private VehicleService vehicleService;
    private VehicleLogService vehicleLogService;
    /**
     * Initializes the servlet and creates instances of services used.
     */

    @Override
    public void init(){
        vehicleService = new VehicleService();
        vehicleLogService = new VehicleLogService();
    }
     /**
     * Handles HTTP GET requests for various vehicle-related views.
     *
     * @param req  HTTP request
     * @param resp HTTP response
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getPathInfo();
        switch (action) {
            case "/register":
                registerPage(req, resp);
                break;
            case "/logUpload":
                logUploadPage(req, resp);
                break;
            case "/log":
                logPage(req, resp);
                break;
            case "/list":
                list(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
    
    /**
     * Handles HTTP POST requests for vehicle registration and log uploads.
     *
     * @param req  HTTP request
     * @param resp HTTP response
     * @throws IOException if an I/O error occurs
     */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getPathInfo();
        switch (action) {
            case "/register":
                register(req, resp);
                break;
            case "/log":
                log(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
    
     /**
     * Forwards request to the vehicle registration JSP page.
     *
     * @param req  HTTP request
     * @param resp HTTP response
     * @throws IOException if an I/O error occurs
     */

    private void registerPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            req.getRequestDispatcher("/jsp/vehicle-register.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
    
    /**
     * Forwards request to the vehicle log upload JSP page.
     *
     * @param req  HTTP request
     * @param resp HTTP response
     * @throws IOException if an I/O error occurs
     */
    
    private void logUploadPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            req.getRequestDispatcher("/jsp/log-upload.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
    
     /**
     * Retrieves vehicle logs for a given vehicle number and forwards to the vehicle log JSP page.
     *
     * @param req  HTTP request
     * @param resp HTTP response
     * @throws IOException if an I/O error occurs
     */
    
    private void logPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String vehicleNumber = req.getParameter("vehicleNumber");
        List<VehicleLogDTO> data = vehicleLogService.search(vehicleNumber);
        req.setAttribute("data", data);
        try {
            req.getRequestDispatcher("/jsp/vehicle-log.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
    
    
     /**
     * Registers a new vehicle using parameters from the request, then redirects to the vehicle list page.
     *
     * @param req  HTTP request
     * @param resp HTTP response
     * @throws IOException if an I/O error occurs
     */

    private void register(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        
        String vehicleType = req.getParameter("vehicleType");
        String vehicleNumber = req.getParameter("vehicleNumber");
        String route = req.getParameter("route");

        RegisterVehicleRequest registerRequest = new RegisterVehicleRequest();
        registerRequest.setVehicleType(vehicleType);
        registerRequest.setVehicleNumber(vehicleNumber);
        registerRequest.setRoute(route);

        vehicleService.registerVehicle(registerRequest);

        resp.sendRedirect(req.getContextPath() + "/vehicle/list");
    }
    
    /**
     * Lists vehicles matching an optional vehicle number parameter and forwards to the vehicles JSP page.
     *
     * @param req  HTTP request
     * @param resp HTTP response
     * @throws IOException if an I/O error occurs
     */

    private void list(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<VehicleDTO> data = vehicleService.search(req.getParameter("vehicleNumber"));
        req.setAttribute("vehicles", data);
        try {
            req.getRequestDispatcher("/jsp/vehicles.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }

    }
    
     /**
     * Handles vehicle log upload requests. Uses the logged-in user from session
     * and delegates to VehicleLogService.
     *
     * @param req  HTTP request
     * @param resp HTTP response
     * @throws IOException if an I/O error occurs
     */

    private void log(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserDTO user = (UserDTO) req.getSession().getAttribute("user");
        LogUploadRequest logUploadRequest = new LogUploadRequest();
        logUploadRequest.setVehicleNumber(req.getParameter("vehicleNumber"));
        logUploadRequest.setEventType(req.getParameter("eventType"));
        logUploadRequest.setLocation(req.getParameter("location"));
        vehicleLogService.upload(logUploadRequest, user);
        try {
            req.getRequestDispatcher("/jsp/log-upload.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
