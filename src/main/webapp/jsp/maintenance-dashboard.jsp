<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.algonquin.www.domain.VehicleDTO" %>

<%
    List<VehicleDTO> maintenances = (List<VehicleDTO>) request.getAttribute("maintenanceList");
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
    <h2>Maintenance Dashboard</h2>

    <!-- Filter Form -->
    <form class="filter-form" method="get" action="../maintenance/dashboard">
        <label for="vehicleNumber">Vehicle Number:</label>
        <input type="text" id="vehicleNumber" name="vehicleNumber" value="${param.vehicleId}"/>
        <button type="submit">Filter</button>
    </form>

    <!-- Results Table -->
    <table class="maintenance-table">
        <thead>
        <tr>
            <th>Vehicle Number</th>
            <th>Type</th>
            <th>Status</th>
            <th>Component Detail</th>
        </tr>
        </thead>
        <tbody>
        <% for (VehicleDTO item : maintenances) {%>
        <tr>
            <td><%= item.getVehicleNumber() %>
            </td>
            <td><%= item.getVehicleType() %>
            </td>
            <td><%= item.getStatus() %>
            </td>
            <td>
                <a href="<%= request.getContextPath()%>/maintenance/components?vehicleNumber=<%= item.getVehicleNumber()%>">Detail</a>
            </td>
        </tr>
        <% }%>
        </tbody>
    </table>
</div>
</body>
</html>
