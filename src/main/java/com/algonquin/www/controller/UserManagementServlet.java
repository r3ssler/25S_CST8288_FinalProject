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


public class UserManagementServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init(){
        userService = new UserService();
    }
    
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
