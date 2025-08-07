<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%
  String errorMessage = (String) request.getAttribute("errorMessage");
  if (errorMessage == null || errorMessage.trim().isEmpty()) {
    errorMessage = "Unknown error occurred.";
  }
%>
<!DOCTYPE html>
<html>
<head>
  <title>Error</title>
  <link rel="stylesheet" type="text/css" href="../css/error.css">
</head>
<body>
<div class="error-box">
  <h2>An Error Occurred</h2>
  <p><%= errorMessage %></p>
  <a class="back-link" href="javascript:history.back()">← Go Back</a>
</div>
</body>
</html>
