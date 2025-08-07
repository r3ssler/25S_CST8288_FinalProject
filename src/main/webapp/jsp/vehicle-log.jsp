<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.algonquin.www.domain.VehicleLogDTO" %>

<%
    List<VehicleLogDTO> data = (List<VehicleLogDTO>) request.getAttribute("data");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vehicle Logs</title>

    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../css/menu.css"/>
    <link rel="stylesheet" type="text/css" href="../css/ribbon.css"/>
</head>
<body>

<jsp:include page="ribbon.jsp"/>
<jsp:include page="menu.jsp"/>

<div class="main">
    <h2>Vehicle Logs</h2>

    <table class="maintenance-table">
        <thead>
        <tr>
            <th>Vehicle Number</th>
            <th>Event Type</th>
            <th>Location</th>
            <th>Time</th>
        </tr>
        </thead>
        <tbody>
        <% if (data != null && !data.isEmpty()) {
            for (VehicleLogDTO item : data) { %>
            <tr>
                <td><%= item.getVehicleNumber() %></td>
                <td><%= item.getLogType() %></td>
                <td><%= item.getLocation() %></td>
                <td><%= item.getLogTime() %></td>
            </tr>
        <%   }
           } else { %>
            <tr>
                <td colspan="4" style="text-align: center; font-style: italic; color: #888;">
                    No log records found.
                </td>
            </tr>
        <% } %>
        </tbody>
    </table>
</div>

</body>
</html>
