<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.algonquin.www.domain.VehicleDTO" %>

<%
    List<VehicleDTO> vehicles = (List<VehicleDTO>) request.getAttribute("vehicles");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vehicle List</title>

    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../css/menu.css"/>
    <link rel="stylesheet" type="text/css" href="../css/ribbon.css"/>
</head>
<body>

<jsp:include page="ribbon.jsp"/>
<jsp:include page="menu.jsp"/>

<div class="main">
    <h2>Vehicles Overview</h2>

    <!-- Filter Form -->
    <form class="filter-form" method="get" action="../vehicle/list">
        <label for="vehicleNumber">Vehicle Number:</label>
        <input type="text" id="vehicleNumber" name="vehicleNumber" value="${param.vehicleNumber}"/>
        <button type="submit">Filter</button>
    </form>

    <!-- Results Table -->
    <table class="maintenance-table">
        <thead>
        <tr>
            <th>Vehicle Number</th>
            <th>Vehicle Type</th>
            <th>Energy Type</th>
            <th>Consumption Rate</th>
            <th>Max Passengers</th>
            <th>Route</th>
            <th>Status</th>
            <th>Log Detail</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${empty vehicles}">
            <tr>
                <td colspan="8" style="text-align: center; color: #888;">No vehicles found.</td>
            </tr>
        </c:if>
        <% for (VehicleDTO item : vehicles) { %>
        <tr>
            <td><%= item.getVehicleNumber() %></td>
            <td><%= item.getVehicleType() %></td>
            <td><%= item.getEnergyType() %></td>
            <td><%= item.getConsumptionRate() != null ? item.getConsumptionRate() : "-" %></td>
            <td><%= item.getMaxPassengers() != null ? item.getMaxPassengers() : "-" %></td>
            <td><%= item.getRoute() %></td>
            <td><%= item.getStatus() %></td>
            <td>
                <a href="<%= request.getContextPath() %>/vehicle/log?vehicleNumber=<%= item.getVehicleNumber() %>">Detail</a>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
</body>
</html>
