<%--    <%@ page import="lombok.experimental.var" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: young
  Date: 2020-02-29
  Time: 오전 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<%
    Object subMenu = request.getParameter("subMenu");
%>

<c:set var="subMenu" value="<%=subMenu%>"></c:set>

<!-- Sidebar -->
<ul class="sidebar navbar-nav">
    <li class="nav-item <c:if test="${subMenu eq 'main'}">active</c:if>">
        <a class="nav-link" href="main">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Dashboard</span>
        </a>
    </li>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-folder"></i>
            <span>Pages</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <h6 class="dropdown-header">Login Screens:</h6>
                <a class="dropdown-item" href="login">Login</a>
                <a class="dropdown-item" href="register">Register</a>
                <a class="dropdown-item" href="forgot-password">Forgot Password</a>
                <div class="dropdown-divider"></div>
                <h6 class="dropdown-header">Other Pages:</h6>
                <a class="dropdown-item" href="404">404 Page</a>
                <a class="dropdown-item" href="blank">Blank Page</a>
        </div>
    </li>
    <li class="nav-item <c:if test="${subMenu eq 'charts'}">active</c:if>" >
        <a class="nav-link" href="charts">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>Charts</span>
        </a>
    </li>
    <li class="nav-item <c:if test="${subMenu eq 'tables'}">active</c:if>">
        <a class="nav-link" href="tables">
            <i class="fas fa-fw fa-table"></i>
            <span>Tables</span>
        </a>
    </li>
    <li class="nav-item <c:if test="${subMenu eq 'tables-houseInfo'}">active</c:if>">
        <a class="nav-link" href="tables-houseInfo">
            <i class="fas fa-fw fa-table"></i>
            <span>Tables-HouseInfo</span>
        </a>
    </li>
</ul>
