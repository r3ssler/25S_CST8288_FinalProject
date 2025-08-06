<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.algonquin.www.domain.ComponentDTO" %>

<%
    List<ComponentDTO> components = (List<ComponentDTO>) request.getAttribute("componentList");
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

    <!-- Results Table -->
    <table class="maintenance-table">
        <thead>
        <tr>
            <th>Vehicle Number</th>
            <th>Name</th>
            <th>Used hours</th>
        </tr>
        </thead>
        <tbody>
        <% for (ComponentDTO item : components) {%>
        <tr>
            <td><%= item.getVehicleNumber() %>
            </td>
            <td><%= item.getName() %>
            </td>
            <td><%= item.getUsedHours() %>
            </td>
        </tr>
        <% }%>
        </tbody>
    </table>

    <!-- Notification -->
    <div id="notification" style="display: none; margin-top: 15px; font-weight: bold;"></div>

    <!-- Action Buttons -->
    <div class="button-container" style="margin-top: 20px;">
        <button type="button" onclick="sendAutoRequest()">Auto Maintenance</button>
        <button type="button" onclick="sendForceRequest()">Force Maintenance</button>
    </div>
</div>

<script>
    function showNotification(message, success = true) {
        const notif = document.getElementById("notification");
        notif.style.display = "block";
        notif.style.color = success ? "green" : "red";
        notif.innerText = message;
    }

    function sendAutoRequest() {
        fetch('/maintenance/auto', {
            method: 'POST'
        })
            .then(response => {
                if (response.ok) {
                    showNotification("Auto maintenance request succeeded.");
                } else {
                    throw new Error("Request failed");
                }
            })
            .catch(() => {
                showNotification("Auto maintenance request failed.", false);
            });
    }

    function sendForceRequest() {
        fetch('/maintenance/force', {
            method: 'POST'
        })
            .then(response => {
                if (response.ok) {
                    showNotification("Force maintenance request succeeded.");
                } else {
                    throw new Error("Request failed");
                }
            })
            .catch(() => {
                showNotification("Force maintenance request failed.", false);
            });
    }
</script></body>
</html>
