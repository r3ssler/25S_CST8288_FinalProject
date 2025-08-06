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

public class MaintenanceManagementServlet extends HttpServlet {

    private MaintenanceService maintenanceService;
    private VehicleService vehicleService;
    
    @Override
    public void init() {
        maintenanceService = new MaintenanceService();
        vehicleService = new VehicleService();
    }
    
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

    private void autoMaintenanceCheck(HttpServletRequest req, HttpServletResponse resp) {
        maintenanceService.autoCheckMaintenance(req.getParameter("vehicleNumber"));
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    private void forceMaintenance(HttpServletRequest req, HttpServletResponse resp) {
        maintenanceService.forceMaintenance(req.getParameter("vehicleNumber"));
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
