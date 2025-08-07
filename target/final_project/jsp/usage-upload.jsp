<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vehicle Event Form</title>

    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../css/menu.css"/>
    <link rel="stylesheet" type="text/css" href="../css/ribbon.css"/>
    <link rel="stylesheet" type="text/css" href="../css/usage-upload.css"/>
</head>
<body>

<jsp:include page="ribbon.jsp"/>
<jsp:include page="menu.jsp"/>

<div class="main">
    <h2>Vehicle Event Form</h2>
    <form class="normal-form" method="post" action="../usage/expense">
        <div class="form-group">
            <label for="vehicleNumber">Vehicle Number</label>
            <input type="text" id="vehicleNumber" name="vehicleNumber" required placeholder="e.g. BUS1234">
        </div>

        <div class="form-group">
            <label for="eventType">Event Type</label>
            <select id="eventType" name="eventType" required>
                <option value="" disabled selected>-- Select Type --</option>
                <option value="fuel">Fuel</option>
                <option value="maintenance">Maintenance</option>
                <option value="inspection">Inspection</option>
                <option value="repair">Repair</option>
            </select>
        </div>

        <div class="form-group">
            <label for="expense">Expense ($)</label>
            <input type="number" id="expense" name="expense" step="0.01" required>
        </div>

        <div class="form-group">
            <label for="usageAmount">Usage Amount (e.g., liters, hours)</label>
            <input type="number" id="usageAmount" name="usageAmount" step="0.01" required>
        </div>

        <div class="form-group">
            <label for="lastMileAmount">Last Mile Reading (km)</label>
            <input type="number" id="lastMileAmount" name="lastMileAmount" step="0.01" required>
        </div>

        <div class="form-group">
            <label for="currentMileAmount">Current Mile Reading (km)</label>
            <input type="number" id="currentMileAmount" name="currentMileAmount" step="0.01" required>
        </div>

        <button type="submit">Submit</button>
    </form>
</div>

</body>
</html>
