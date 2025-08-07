package com.algonquin.www.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


/**
 * Servlet responsible for serving common layout components such as the menu and ribbon.
 * <p>
 * This servlet handles HTTP GET requests and dynamically forwards them to specific JSP
 * layout fragments based on the request path.
 * </p>
 *
 * <p>
 * Supported paths:
 * <ul>
 *     <li><code>/menu</code> → forwards to <code>/jsp/menu.jsp</code></li>
 *     <li><code>/ribbon</code> → forwards to <code>/jsp/ribbon.jsp</code></li>
 * </ul>
 * </p>
 *
 * <p>
 * If the request path does not match any known component, a 404 error is returned.
 * </p>
 *
 * <pre>
 * Example usage:
 * GET /layout/menu → renders the menu component
 * GET /layout/ribbon → renders the ribbon component
 * </pre>
 *
 * @author 
 * @version 1.0
 * @since 2025-08-07
 */


public class LayoutComponentServlet extends HttpServlet {
    
     /**
     * Handles GET requests to serve layout component JSPs.
     *
     * @param req  the {@link HttpServletRequest} object
     * @param resp the {@link HttpServletResponse} object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String path = req.getPathInfo();
        String jspPath;

        if (path == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        switch (path) {
            case "/menu":
                jspPath = "/jsp/menu.jsp";
                break;
            case "/ribbon":
                jspPath = "/jsp/ribbon.jsp";
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                return;
        }

        req.getRequestDispatcher(jspPath).forward(req, resp);
    }
}
