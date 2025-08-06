
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

public class VehicleManagementServlet extends HttpServlet {

    private VehicleService vehicleService;
    private VehicleLogService vehicleLogService;
    
    @Override
    public void init(){
        vehicleService = new VehicleService();
        vehicleLogService = new VehicleLogService();
    }
    
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

    private void registerPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            req.getRequestDispatcher("/jsp/vehicle-register.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
    
    private void logUploadPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            req.getRequestDispatcher("/jsp/log-upload.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
    
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
