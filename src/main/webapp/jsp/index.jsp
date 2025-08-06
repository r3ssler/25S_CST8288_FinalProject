<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.algonquin.www.domain.UserDTO" %>
<%
    // Authentication check
    UserDTO user = (UserDTO) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    String name = user.getName();
    String role = user.getType(); // Expected values: "admin", "operator", etc.
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>PTFMS Dashboard</title>
    <link rel="stylesheet" type="text/css" href="../css/common.css" />
    <link rel="stylesheet" type="text/css" href="../css/menu.css" />
    <link rel="stylesheet" type="text/css" href="../css/ribbon.css" />
    <style>
        .main {
            margin-left: 200px;
            margin-top: 60px;
            padding: 20px;
        }

        h2 {
            color: #2c3e50;
        }

        .section {
            margin-bottom: 30px;
            padding: 15px;
            border: 1px solid #ddd;
            border-radius: 8px;
            background-color: #fefefe;
            box-shadow: 0 2px 5px rgba(0,0,0,0.05);
        }

        .section h3 {
            margin-bottom: 10px;
            color: #2980b9;
        }

        .link-button {
            display: inline-block;
            margin: 5px 10px 0 0;
            padding: 8px 16px;
            background-color: #3498db;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }

        .link-button:hover {
            background-color: #2980b9;
        }

        .logout {
            margin-top: 30px;
            display: inline-block;
            background-color: #e74c3c;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 6px;
        }

        .logout:hover {
            background-color: #c0392b;
        }
    </style>
</head>
<body>

<jsp:include page="ribbon.jsp" />
<jsp:include page="menu.jsp" />

<div class="main">
    <h2>Welcome, <%= name %>!</h2>
    <p>You are logged in as <strong><%= role.toUpperCase() %></strong>.</p>

    <%-- Admin Content --%>
    <%
        if ("admin".equalsIgnoreCase(role)) {
    %>
        <div class="section">
            <h3>Admin Tools</h3>
            <a class="link-button" href="<%= request.getContextPath() %>/vehicle/register">Register Vehicle</a>
            <a class="link-button" href="<%= request.getContextPath() %>/maintenance/dashboard">Maintenance Dashboard</a>
            <a class="link-button" href="<%= request.getContextPath() %>/usage/upload">Upload Usage Data</a>
            <a class="link-button" href="<%= request.getContextPath() %>/vehicle/logUpload">Upload Log Data</a>
            <a class="link-button" href="<%= request.getContextPath() %>/usage/report">Usage Report</a>
        </div>

    <%
        }
    %>

    <%-- Operator Content --%>
    <%
        if ("operator".equalsIgnoreCase(role)) {
    %>
        <div class="section">
            <h3>Operator Actions</h3>
            <a class="link-button" href="<%= request.getContextPath() %>/vehicle/list">View Vehicles - Maintenance</a>
            <a class="link-button" href="<%= request.getContextPath() %>/vehicle/logUpload">Vehicle Logs Upload</a>
            <a class="link-button" href="<%= request.getContextPath() %>/usage/report">Usage Reports</a>
            <a class="link-button" href="<%= request.getContextPath() %>/usage/upload">Usage Upload</a>
        </div>

    <%
        }
    %>

    <%-- Shared Section (for all users) --%>
    <div class="section">
        <h3>Reports & Metrics</h3>
        <a class="link-button" href="<%= request.getContextPath() %>/user/performance">Performance Metrics</a>
    </div>

    <a href="logout.jsp" class="logout">Logout</a>
</div>

</body>
</html>
