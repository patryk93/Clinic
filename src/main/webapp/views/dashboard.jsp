<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 27.05.2023
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul class="nav flex-column long-bg">
    <li class="nav-item">
        <a class="nav-link" href="/app/editUserData">
            <span>Mój profil</span>
            <i class="fas fa-angle-right"></i>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/logged">
            <span>Pulpit</span>
            <i class="fas fa-angle-right"></i>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/logged/patient/all">
            <span>Pacjenci</span>
            <i class="fas fa-angle-right"></i>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/app/plan/list">
            <span>Wizyty</span>
            <i class="fas fa-angle-right"></i>
        </a>
    </li>

<%--    <li class="nav-item">--%>
<%--        <a class="nav-link" href="/app/adminUsers">--%>
<%--            <span>Użytkownicy</span>--%>
<%--            <i class="fas fa-angle-right"></i>--%>
<%--        </a>--%>
<%--    </li>--%>
</ul>
</body>
</html>
