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


/**
 * Servlet responsible for handling usage-related operations including
 * uploading usage data, generating reports, and recording expenses.
 * <p>
 * Supported request paths:
 * <ul>
 *   <li>GET /upload - Displays the usage data upload page.</li>
 *   <li>GET /report - Generates and displays usage and expense reports.</li>
 *   <li>POST /expense - Processes an expense report submission.</li>
 * </ul>
 * </p>
 * 
 * <p>
 * Most requests expect parameters such as "vehicleNumber", "eventType", "expense",
 * "usageAmount", "lastMileAmount", and "currentMileAmount" as applicable.
 * </p>
 * 
 * <pre>
 * Example usage:
 * GET /usage/upload
 * GET /usage/report?vehicleNumber=123
 * POST /usage/expense with parameters vehicleNumber=123, eventType=bus, expense=100.0, usageAmount=50.0, lastMileAmount=1000.0, currentMileAmount=1050.0
 * </pre>
 * 
 * @author
 * @version 1.0
 * @since 2025-08-07
 */

public class UsageManagementServlet extends HttpServlet {

    private UsageService usageService;
    
    /**
     * Initializes the servlet and the usage service.
     */
    
    
    @Override
    public void init(){
        usageService = new UsageService();
    }
    
     /**
     * Handles HTTP GET requests for showing upload page and generating reports.
     *
     * @param req  the HTTP request
     * @param resp the HTTP response
     * @throws IOException if an I/O error occurs during request dispatching
     */
    
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
    
    /**
     * Handles HTTP POST requests for recording usage expenses.
     *
     * @param req  the HTTP request
     * @param resp the HTTP response
     * @throws IOException if an I/O error occurs during request dispatching
     */
    
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
    
    /**
     * Forwards to the usage data upload JSP page.
     *
     * @param req  the HTTP request
     * @param resp the HTTP response
     * @throws IOException if forwarding fails
     */
    
    private void showUpload(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            req.getRequestDispatcher("/jsp/usage-upload.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
    
     /**
     * Handles usage report generation for a specific vehicle.
     *
     * @param req  the HTTP request
     * @param resp the HTTP response
     * @throws IOException if forwarding fails
     */


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
    
     /**
     * Processes an expense report submission.
     *
     * @param req  the HTTP request
     * @param resp the HTTP response
     * @throws IOException if forwarding fails
     */
    
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
