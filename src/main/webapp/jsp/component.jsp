<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.algonquin.www.domain.ComponentDTO" %>

<%
    List<ComponentDTO> components = (List<ComponentDTO>) request.getAttribute("componentList");
    String vehicleNumber = components != null && !components.isEmpty() ? components.get(0).getVehicleNumber() : "";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Component Details</title>
    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../css/menu.css"/>
    <link rel="stylesheet" type="text/css" href="../css/ribbon.css"/>
</head>
<body>

<jsp:include page="ribbon.jsp"/>
<jsp:include page="menu.jsp"/>

<div class="main">
    <h2>Component Detail - Vehicle <%= vehicleNumber %></h2>

    <!-- Component Table -->
    <table class="maintenance-table">
        <thead>
        <tr>
            <th>Vehicle Number</th>
            <th>Name</th>
            <th>Used Hours</th>
        </tr>
        </thead>
        <tbody>
        <% for (ComponentDTO item : components) { %>
        <tr>
            <td><%= item.getVehicleNumber() %></td>
            <td><%= item.getName() %></td>
            <td><%= item.getUsedHours() %></td>
        </tr>
        <% } %>
        </tbody>
    </table>

    <!-- Notification -->
    <div id="notification" style="display: none; margin-top: 15px; font-weight: bold;"></div>

    <!-- Action Buttons -->
    <div class="button-container" style="margin-top: 20px;">
        <button type="button" onclick="sendAutoRequest()">🚀 Auto Maintenance</button>
        <button type="button" onclick="sendForceRequest()">🛠 Force Maintenance</button>
    </div>
    
    <!-- Manual Status Update -->
<div class="status-form" style="margin-top: 30px;">
    <h3>Change Vehicle Status</h3>
    <form method="post" action="${pageContext.request.contextPath}/maintenance/status">
        <input type="hidden" name="vehicleNumber" value="<%= vehicleNumber %>"/>
        <select name="newStatus" required>
            <option value="">-- Select Status --</option>
            <option value="Active">Active</option>
            <option value="Inactive">Inactive</option>
            <option value="Maintenance">Maintenance</option>
        </select>
        <button type="submit">Update Status</button>
    </form>
</div>

</div>

<script>
    const vehicleNumber = "<%= vehicleNumber %>";
    const baseUrl = "<%= request.getContextPath() %>";

    function showNotification(message, success = true) {
        const notif = document.getElementById("notification");
        notif.style.display = "block";
        notif.style.color = success ? "green" : "red";
        notif.innerText = message;
    }

    function sendAutoRequest() {
        fetch(baseUrl + '/maintenance/auto', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: 'vehicleNumber=' + encodeURIComponent(vehicleNumber)
        })
        .then(response => {
            if (response.ok) {
                showNotification("✅ Auto maintenance request succeeded.");
                setTimeout(() => {
                    // Redirect to dashboard to show updated vehicle status
                    window.location.href = baseUrl + '/maintenance/dashboard?vehicleNumber=' + encodeURIComponent(vehicleNumber);
                }, 1500);
            } else {
                throw new Error("Request failed");
            }
        })
        .catch(() => {
            showNotification("❌ Auto maintenance request failed.", false);
        });
    }

    function sendForceRequest() {
        fetch(baseUrl + '/maintenance/force', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: 'vehicleNumber=' + encodeURIComponent(vehicleNumber)
        })
        .then(response => {
            if (response.ok) {
                showNotification("✅ Force maintenance request succeeded.");
                setTimeout(() => {
                    // Redirect to dashboard to show updated vehicle status
                    window.location.href = baseUrl + '/maintenance/dashboard?vehicleNumber=' + encodeURIComponent(vehicleNumber);
                }, 1500);
            } else {
                throw new Error("Request failed");
            }
        })
        .catch(() => {
            showNotification("❌ Force maintenance request failed.", false);
        });
    }
    
    
</script>

</body>
</html>
