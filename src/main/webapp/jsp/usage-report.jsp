<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.algonquin.www.model.EfficiencyMetricsResponse" %>
<%@ page import="com.algonquin.www.domain.ExpenseRecordDTO" %>

<%
    List<ExpenseRecordDTO> records = (List<ExpenseRecordDTO>) request.getAttribute("records");
    EfficiencyMetricsResponse metrics = (EfficiencyMetricsResponse) request.getAttribute("metrics");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Usage Report</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/menu.css">
    <link rel="stylesheet" href="../css/ribbon.css">
</head>
<body>

<jsp:include page="ribbon.jsp"/>
<jsp:include page="menu.jsp"/>

<div class="main">
    <h2>Usage Report</h2>

    <%-- KPI Section --%>
    <% if (metrics != null) { %>
    <div style="display: flex; justify-content: space-around; margin: 20px 0;">
        <div style="text-align: center;">
            <div style="font-size: 36px;"><%= metrics.getBus() %></div>
            <div>Diesel or CNG Fuel Efficiency</div>
        </div>
        <div style="text-align: center;">
            <div style="font-size: 36px;"><%= metrics.getTrain() %></div>
            <div>Energy Consumption per Mile</div>
        </div>
        <div style="text-align: center;">
            <div style="font-size: 36px;"><%= metrics.getLightRail() %></div>
            <div>Fuel Usage Tracking</div>
        </div>
        <div style="text-align: center;">
            <div style="font-size: 36px;"><%= metrics.getMaintenance() %></div>
            <div>Maintenance Expenses</div>
        </div>
    </div>
    <% } else { %>
    <p>No efficiency metrics available.</p>
    <% } %>

    <%-- Filter Form --%>
    <form class="filter-form" method="get" action="../usage/report">
        <label for="vehicleNumber">Vehicle Number:</label>
        <input type="text" id="vehicleNumber" name="vehicleNumber" value="${param.vehicleNumber}" />
        <button type="submit">Filter</button>
    </form>

    <%-- Results Table --%>
    <% if (records != null && !records.isEmpty()) { %>
    <table class="maintenance-table">
        <thead>
        <tr>
            <th>Vehicle Number</th>
            <th>Type</th>
            <th>Expense ($)</th>
        </tr>
        </thead>
        <tbody>
        <% for (ExpenseRecordDTO item : records) { %>
        <tr>
            <td><%= item.getVehicleNumber() %></td>
            <td><%= item.getType() %></td>
            <td><%= String.format("%.2f", item.getExpense()) %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <% } else { %>
    <p>No expense records found.</p>
    <% } %>
</div>

</body>
</html>
