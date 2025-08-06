package com.algonquin.www.controller;

import com.algonquin.www.domain.ExpenseRecordDTO;
import com.algonquin.www.model.*;
import com.algonquin.www.service.UsageService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsageManagementServlet extends HttpServlet {

    private UsageService usageService;
    
    @Override
    public void init(){
        usageService = new UsageService();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getPathInfo();
        switch (action) {
            case "/upload":
                showUpload(req, resp);
                break;
            case "/report":
                report(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getPathInfo();
        switch (action) {
            case "/expense":
                expense(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
    
    private void showUpload(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            req.getRequestDispatcher("/jsp/usage-upload.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }


    private void report(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String vehicleNumber = req.getParameter("vehicleNumber");

        ExpenseRecordSearchRequest request = new ExpenseRecordSearchRequest();
        request.setVehicleNumber(vehicleNumber);

        List<ExpenseRecordDTO> data = usageService.expenseRecordSearch(request);
        EfficiencyMetricsResponse metrics = usageService.efficiencyMetrics();
        req.setAttribute("records", data);
        req.setAttribute("metrics", metrics);
        try {
            req.getRequestDispatcher("/jsp/usage-report.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }

    }
    
    private void expense(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ExpenseReportRequest request = new ExpenseReportRequest();
        request.setVehicleNumber(req.getParameter("vehicleNumber"));
        request.setType(req.getParameter("eventType"));
        request.setExpense(Double.parseDouble(req.getParameter("expense")));
        request.setUsageAmount(Double.parseDouble(req.getParameter("usageAmount")));
        request.setLastMile(Double.parseDouble(req.getParameter("lastMileAmount")));
        request.setCurrentMile(Double.parseDouble(req.getParameter("currentMileAmount")));
        usageService.report(request);

        try {
            req.getRequestDispatcher("/jsp/usage-upload.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
