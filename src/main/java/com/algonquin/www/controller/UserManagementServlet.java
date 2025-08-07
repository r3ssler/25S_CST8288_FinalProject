package com.algonquin.www.controller;

import com.algonquin.www.domain.PerformanceMetricDTO;
import com.algonquin.www.domain.UserDTO;
import com.algonquin.www.domain.VehicleLogDTO;
import com.algonquin.www.model.LoginRequest;
import com.algonquin.www.model.LoginResponse;
import com.algonquin.www.model.RegisterRequest;
import com.algonquin.www.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;



/**
 * Servlet responsible for managing user-related operations such as login,
 * registration, and viewing performance metrics.
 * <p>
 * Supported HTTP methods and paths:
 * </p>
 * <ul>
 *   <li>GET /performance - Displays performance metrics for a specified user.</li>
 *   <li>POST /login - Authenticates a user and establishes a session.</li>
 *   <li>POST /register - Registers a new user in the system.</li>
 * </ul>
 * 
 * <p>
 * Usage:
 * <ul>
 *   <li>Login requires "username" and "password" parameters.</li>
 *   <li>Register requires "username", "password", "email", "name", and "type" parameters.</li>
 *   <li>Performance requires "username" parameter.</li>
 * </ul>
 * </p>
 * 
 * <pre>
 * Example usage:
 * POST /user/login
 * POST /user/register
 * GET /user/performance?username=johndoe
 * </pre>
 * 
 * <p>This servlet uses the {@link UserService} for business logic.</p>
 * 
 * @author
 * @version 1.0
 * @since 2025-08-07
 */


public class UserManagementServlet extends HttpServlet {

    private UserService userService;
    
     /**
     * Initializes the servlet and creates a new instance of {@link UserService}.
     */

    @Override
    public void init(){
        userService = new UserService();
    }
    
     /**
     * Handles HTTP GET requests, currently supports:
     * <ul>
     *   <li>/performance - show user performance metrics</li>
     * </ul>
     * 
     * @param req  HTTP request
     * @param resp HTTP response
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getPathInfo();
        switch (action) {
            case "/performance":
                performance(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
    
     /**
     * Handles HTTP POST requests, currently supports:
     * <ul>
     *   <li>/login - authenticate user</li>
     *   <li>/register - register new user</li>
     * </ul>
     * 
     * @param req  HTTP request
     * @param resp HTTP response
     * @throws IOException if an I/O error occurs
     */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getPathInfo();
        switch (action) {
            case "/login":
                login(req, resp);
                break;
            case "/register":
                register(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
    
    /**
     * Authenticates a user based on username and password.
     * If authentication succeeds, sets the user in session and redirects to index page.
     * If authentication fails, forwards to an error JSP page.
     *
     * @param req  HTTP request
     * @param resp HTTP response
     * @throws IOException if an I/O error occurs
     */

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(req.getParameter("username"));
        loginRequest.setPassword(req.getParameter("password"));

        UserDTO response = userService.login(loginRequest);

        try {
            if (response == null) {
                req.setAttribute("errorMessage", "Invalid username or password.");
                req.getRequestDispatcher("/jsp/error.jsp").forward(req, resp);
            } else {
                HttpSession session = req.getSession();
                session.setAttribute("user", response);

                resp.sendRedirect(req.getContextPath() + "/jsp/index.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
    /**
     * Registers a new user using data from the request parameters.
     * After registration, redirects to the login page.
     *
     * @param req  HTTP request
     * @param resp HTTP response
     */

    private void register(HttpServletRequest req, HttpServletResponse resp) {
        RegisterRequest registerRequest = new RegisterRequest();

        registerRequest.setUsername(req.getParameter("username"));
        registerRequest.setPassword(req.getParameter("password"));
        registerRequest.setEmail(req.getParameter("email"));
        registerRequest.setName(req.getParameter("name"));
        String userType = req.getParameter("type");
        registerRequest.setType(userType);

        userService.register(registerRequest);

        try {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Retrieves performance metrics for a specified user and forwards to the performance JSP.
     *
     * @param req  HTTP request
     * @param resp HTTP response
     * @throws IOException if an I/O error occurs
     */
    
    private void performance(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userName = req.getParameter("username");
        List<PerformanceMetricDTO> data = userService.performance(userName);
        req.setAttribute("data", data);
        try {
            req.getRequestDispatcher("/jsp/performance.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }

    }

}
