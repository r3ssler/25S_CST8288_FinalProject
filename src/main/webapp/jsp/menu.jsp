<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.algonquin.www.domain.UserDTO" %>

<%
    UserDTO user = (UserDTO) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
    String role = user.getType(); // "admin", "operator", etc.
    request.setAttribute("role", role); // Make available to JSTL
%>

<div class="menu">
    <ul>
        <li><a href="<c:url value='/jsp/index.jsp'/>">Home</a></li>

        <c:if test="${role == 'admin'}">
            <li><a href="<c:url value='/user/performance'/>">User Performance</a></li>
            <li><a href="<c:url value='/vehicle/register'/>">Vehicle Register</a></li>
            <li><a href="<c:url value='/vehicle/list'/>">Vehicles</a></li>
        </c:if>

        <c:if test="${role == 'admin' || role == 'operator'}">
            <li><a href="<c:url value='/vehicle/logUpload'/>">Vehicle Log Upload</a></li>
            <li><a href="<c:url value='/maintenance/dashboard'/>">Maintenance</a></li>
            <li><a href="<c:url value='/usage/report'/>">Usage Report</a></li>
            <li><a href="<c:url value='/usage/upload'/>">Usage Upload</a></li>
        </c:if>
    </ul>
</div>
