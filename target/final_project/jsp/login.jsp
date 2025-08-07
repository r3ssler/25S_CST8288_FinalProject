<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login - PTFMS</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/login.css">
</head>
<body>
<div class="login-container">
    <div class="login-box">
        <h2>Login</h2>

        <%-- Optional: Show message after logout --%>
        <%
            String logoutMsg = request.getParameter("logout");
            if ("true".equals(logoutMsg)) {
        %>
        <div style="color: green; font-weight: bold; margin-bottom: 10px;">
            You have been logged out successfully.
        </div>
        <% } %>

        <%-- Login Form --%>
        <form action="<%= request.getContextPath() %>/user/login" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required />

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required />

            <button type="submit">Login</button>
            <button type="button" onclick="window.location.href='signup.jsp'">Sign Up</button>
        </form>
    </div>
</div>
</body>
</html>
