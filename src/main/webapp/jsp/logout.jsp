<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    // End the session to log the user out
    session.invalidate();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="refresh" content="2;URL=<%=request.getContextPath()%>/user/login.jsp">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Logout - PTFMS</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/menu.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/ribbon.css"/>
</head>
<body>

<jsp:include page="ribbon.jsp"/>
<jsp:include page="menu.jsp"/>

<div class="main">
    <h2>You have been logged out.</h2>
    <p>Redirecting to <a href="<%=request.getContextPath()%>/user/login.jsp">login page</a>...</p>
</div>

</body>
</html>
