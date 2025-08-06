<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.algonquin.www.domain.PerformanceMetricDTO" %>

<%
    List<PerformanceMetricDTO> data = (List<PerformanceMetricDTO>) request.getAttribute("data");
%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Template</title>

    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../css/menu.css"/>
    <link rel="stylesheet" type="text/css" href="../css/ribbon.css"/>
</head>
<body>

<jsp:include page="ribbon.jsp"/>
<jsp:include page="menu.jsp"/>

<div class="main">
    <h2>User Performance</h2>

    <!-- Filter Form -->
    <form class="filter-form" method="get" action="../user/performance">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" value="${param.username}"/>
        <button type="submit">Filter</button>
    </form>

    <!-- Results Table -->
    <table class="maintenance-table">
        <thead>
        <tr>
            <th>User ID</th>
            <th>User Name</th>
            <th>Total Trips</th>
            <th>On-Time Trips</th>
            <th>Total Time (min)</th>
        </tr>
        </thead>
        <tbody>
        <% for (PerformanceMetricDTO item : data) { %>
        <tr>
            <td><%= item.getUserId() %></td>
            <td><%= item.getUserName() %></td>
            <td><%= item.getTotalTrip() %></td>
            <td><%= item.getTotalOnTimeTrip() %></td>
            <td><%= item.getTotalTime() %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
</body>
</html>
