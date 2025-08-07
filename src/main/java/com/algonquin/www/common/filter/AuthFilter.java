package com.algonquin.www.common.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet Filter that handles authentication and access control for web requests.
 * <p>
 * This filter intercepts incoming HTTP requests to check if the user is logged in by
 * verifying the session attribute "user". It allows unauthenticated access to the login
 * and signup pages as well as static resources (e.g., JS and CSS files).
 * </p>
 * 
 * <p>
 * If the user is not logged in and tries to access a protected resource, the filter
 * redirects the user to the login page.
 * </p>
 * 
 * <p>
 * Typical flow:
 * <ul>
 *   <li>Allow access to static resources (files ending with .js, .css).</li>
 *   <li>Allow access to login and signup pages.</li>
 *   <li>If user is logged in (session contains "user"), allow access.</li>
 *   <li>Otherwise, redirect to the login page.</li>
 * </ul>
 * </p>
 * 
 * @see Filter
 */

public class AuthFilter implements Filter {
    
     /**
     * Intercepts HTTP requests and enforces authentication checks.
     * 
     * @param request  the incoming {@link ServletRequest}
     * @param response the outgoing {@link ServletResponse}
     * @param chain    the {@link FilterChain} to pass the request/response along
     * @throws IOException      if an input or output error occurs during filtering
     * @throws ServletException if the request cannot be handled
     */
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        try {

            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;

            String uri = req.getRequestURI();
             // Allow static resources through without authentication check
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
                 // User is logged in or accessing login/signup, so continue request
                chain.doFilter(request, response);
            } else {
                // Redirect to login page if not authenticated
                res.sendRedirect(loginURI);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
