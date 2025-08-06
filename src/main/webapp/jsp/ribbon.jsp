<%@ page import="com.algonquin.www.domain.UserDTO" %>
<%
    UserDTO user = (UserDTO) session.getAttribute("user");
    String displayName = (user != null && user.getName() != null) ? user.getName() : "Guest";
%>

<div class="ribbon">
    Welcome <span id="userName"><%= displayName %></span>
</div>
