<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 27.05.2023
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Mediculum</title>
  <link rel="stylesheet" href='<c:url value="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"/>' integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">
  <link href='<c:url value="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"/>'
        rel="stylesheet">
  <link href='<c:url value="/css/style.css"/>' rel="stylesheet" type="text/css">
  <link rel="stylesheet" href='<c:url value="https://use.fontawesome.com/releases/v5.5.0/css/all.css"/>' integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>
<body>

<header class="page-header">
    <c:if test="${not empty loggedUser}">
  <nav class="navbar navbar-expand-lg justify-content-around">
      <a href="/logged" class="navbar-brand main-logo">
      Medi<span>culum</span>
    </a>
    <div class="d-flex justify-content-around">
      <h4 class="text-light mr-3">Dzień dobry, ${loggedUser.firstName}</h4>
        <div class="circle-div text-center"><i class="fas fa-user icon-user"></i></div>
    </div>
  </nav>
  <ul class="nav nounderline text-uppercase">
    <li class="nav-item ml-4">
      <a class="nav-link" href="/logout">Wyloguj się</a>
    </li>
  </c:if>

      <%--            <li class="nav-item ml-4">--%>
      <%--                <a class="nav-link" href="/about">o aplikacji</a>--%>
      <%--            </li>--%>
      <%--            <li class="nav-item ml-4">--%>
      <%--                <a class="nav-link disabled" href="/contact">Kontakt</a>--%>
      <%--            </li>--%>
    </ul>
  </nav>
</header>


</body>
</html>
