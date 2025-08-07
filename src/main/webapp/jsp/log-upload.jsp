<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Vehicle Log Upload</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../css/menu.css"/>
    <link rel="stylesheet" type="text/css" href="../css/ribbon.css"/>
    <link rel="stylesheet" type="text/css" href="../css/usage-upload.css"/>
</head>
<body>

<jsp:include page="ribbon.jsp"/>
<jsp:include page="menu.jsp"/>

<div class="main">
    <h2>Vehicle Log Upload</h2>

    <form class="normal-form" method="post" action="../vehicle/log">
        <div class="form-group">
            <label for="vehicleNumber">Vehicle Number</label>
            <input type="text" id="vehicleNumber" name="vehicleNumber" required />
        </div>

        <div class="form-group">
            <label for="logType">Event Type</label>
            <select id="eventType" name="eventType" required>
                <option value="">-- Select Event Type --</option>
                <option value="Start">Start Trip</option>
                <option value="Stop">End Trip</option>
                <option value="Breakdown">Break</option>
                <option value="OutOfService">Out of Service</option>
            </select>
        </div>

        <div class="form-group">
            <label for="location">Location</label>
            <input type="text" id="location" name="location" required />
        </div>

        <button type="submit">Submit</button>
    </form>
</div>

</body>
</html>
