<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register Vehicle</title>

    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../css/menu.css"/>
    <link rel="stylesheet" type="text/css" href="../css/ribbon.css"/>
    <link rel="stylesheet" type="text/css" href="../css/usage-upload.css"/>
</head>
<body>

<jsp:include page="ribbon.jsp"/>
<jsp:include page="menu.jsp"/>

<div class="main">
    <h2>Register Vehicle</h2>
    <form class="normal-form" method="post" action="../vehicle/register">
        <div class="form-group">
            <label for="vehicleNumber">Vehicle Number</label>
            <input type="text" id="vehicleNumber" name="vehicleNumber" required>
        </div>

        <div class="form-group">
            <label for="vehicleType">Vehicle Type</label>
            <select id="vehicleType" name="vehicleType" required>
                <option value="">-- Select Vehicle Type --</option>
                <option value="Bus">Bus</option>
                <option value="Light Rail">Light Rail</option>
                <option value="Train">Train</option>
            </select>
        </div>

        <div class="form-group">
            <label for="energyType">Energy Type</label>
            <select id="energyType" name="energyType" required>
                <option value="">-- Select Energy Type --</option>
                <option value="Diesel">Diesel</option>
                <option value="Electric">Electric</option>
                <option value="Hybrid">Hybrid</option>
            </select>
        </div>

        <div class="form-group">
            <label for="consumptionRate">Consumption Rate (per km or hour)</label>
            <input type="number" step="0.01" id="consumptionRate" name="consumptionRate">
        </div>

        <div class="form-group">
            <label for="maxPassengers">Max Passengers</label>
            <input type="number" id="maxPassengers" name="maxPassengers">
        </div>

        <div class="form-group">
            <label for="route">Route</label>
            <input type="text" id="route" name="route">
        </div>

        <div class="form-group">
            <label for="status">Status</label>
            <select id="status" name="status">
                <option value="Active">Active</option>
                <option value="Under Maintenance">Under Maintenance</option>
                <option value="Inactive">Inactive</option>
            </select>
        </div>

        <button type="submit">Register Vehicle</button>
    </form>
</div>

</body>
</html>
