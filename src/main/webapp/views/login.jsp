<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 17.05.2023
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Logowanie</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"
          rel="stylesheet">
    <link href='<c:url value="/css/style.css"/>' rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">

</head>
<body>
<jsp:include page="header.jsp"/>
<section class="dashboard-section">
    <div class="container pt-4 pb-4">
        <div class="border-dashed view-height">
            <div class="container w-25">
<form:form action="/login" modelAttribute="loginForm" method="post" class="padding-small text-center">
    <div>
        <a href="/register/add" width="400" height="200">Nie masz konta? Zarejestruj się</a><br/>
    </div>
    <h1 class="text-color-darker">Logowanie</h1>
    <form:input class="form-control" path="login" id="login" placeholder="Login"/><br/>
    <form:errors path="login" /><br/>

    <form:input class="form-control" path="password" id="password" type="Password" placeholder="Hasło"/><br/>
    <form:errors path="password" /><br/>

    <button class="btn btn-color rounded-0" type="submit">Zaloguj</button>
    <br/>
    <br/>
    <button class="btn btn-color rounded-0" type="reset">Wyczyść</button>
    <br/>
    </form:form>
            </div>
    <div id="back">
        <a href="/"> <img src="../images/buttonBack.jpg" alt="cofnij" width="250" height="150"></a>
    </div>
        </div>
    </div>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>
