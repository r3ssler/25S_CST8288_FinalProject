package com.algonquin.www.service;

import com.algonquin.www.dao.PerformanceMetricDAO;
import com.algonquin.www.dao.UserDAO;
import com.algonquin.www.dao.impl.PerformanceMetricDAOImpl;
import com.algonquin.www.dao.impl.UserDAOImpl;
import com.algonquin.www.domain.PerformanceMetricDTO;
import com.algonquin.www.domain.UserDTO;
import com.algonquin.www.model.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
/**
 * Service class responsible for user management and performance retrieval.
 * <p>
 * Provides methods for user login, registration, and fetching performance metrics.
 * </p>
 */

public class UserService {

    private UserDAO userDAO;

    private PerformanceMetricDAO performanceMetricDAO;
     /**
     * Constructs a new UserService instance.
     * <p>
     * Initializes UserDAO and PerformanceMetricDAO implementations.
     * </p>
     */

    public UserService() {
        userDAO = new UserDAOImpl();
        performanceMetricDAO = new PerformanceMetricDAOImpl();
    }
     /**
     * Attempts to authenticate a user using the provided login credentials.
     *
     * @param request the {@link LoginRequest} containing username and password
     * @return the matching {@link UserDTO} if authentication succeeds; otherwise, null
     */

    public UserDTO login(LoginRequest request) {
        return userDAO.findUser(request.getUsername(), request.getPassword());
    }
    /**
     * Registers a new user with the system.
     *
     * @param request the {@link RegisterRequest} containing user registration details
     */ 

    public void register(RegisterRequest request) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(request.getUsername());
        userDTO.setPassword(request.getPassword());
        userDTO.setEmail(request.getEmail());
        userDTO.setName(request.getName());
        userDTO.setType(request.getType());
        userDAO.addUser(userDTO);
    }
     /**
     * Retrieves performance metrics for users.
     * <p>
     * If a username is provided, returns the performance metric for that specific user.
     * If no username is provided, returns the performance metrics for all users.
     * </p>
     *
     * @param username the username to filter by; if null or empty, fetches all performance metrics
     * @return a list of {@link PerformanceMetricDTO} objects matching the criteria
     */

    public List<PerformanceMetricDTO> performance(String username) {
        if (username == null || username.isEmpty()) {
            return performanceMetricDAO.selectAll();
        } else {
            List<PerformanceMetricDTO> data = new ArrayList<>();
            PerformanceMetricDTO performanceMetricDTO = performanceMetricDAO.selectByUserName(username);
            if (performanceMetricDTO != null) {
                data.add(performanceMetricDTO);
            }
            return data;
        }
    }
}
