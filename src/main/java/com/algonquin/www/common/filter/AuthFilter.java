package com.algonquin.www.common.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class AuthFilter implements Filter {
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        try {

            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;

            String uri = req.getRequestURI();
            if (uri.endsWith(".js") || uri.endsWith(".css")) {
                chain.doFilter(request, response);
                return;
            }

            HttpSession session = req.getSession(false);
            boolean loggedIn = (session != null && session.getAttribute("user") != null);
            String loginURI = req.getContextPath() + "/jsp/login.jsp";
            String signUpURI = req.getContextPath() + "/jsp/signup.jsp";

            boolean loginRequest = req.getRequestURI().equals(loginURI)
                    || req.getRequestURI().endsWith("/login");

            boolean signUpRequest = req.getRequestURI().equals(signUpURI)
                    || req.getRequestURI().endsWith("/register");

            if (loggedIn || loginRequest || signUpRequest) {
                chain.doFilter(request, response);
            } else {
                res.sendRedirect(loginURI);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
