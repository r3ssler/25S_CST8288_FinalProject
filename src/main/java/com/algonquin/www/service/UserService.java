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

public class UserService {

    private UserDAO userDAO;

    private PerformanceMetricDAO performanceMetricDAO;

    public UserService() {
        userDAO = new UserDAOImpl();
        performanceMetricDAO = new PerformanceMetricDAOImpl();
    }

    public UserDTO login(LoginRequest request) {
        return userDAO.findUser(request.getUsername(), request.getPassword());
    }

    public void register(RegisterRequest request) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(request.getUsername());
        userDTO.setPassword(request.getPassword());
        userDTO.setEmail(request.getEmail());
        userDTO.setName(request.getName());
        userDTO.setType(request.getType());
        userDAO.addUser(userDTO);
    }

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
