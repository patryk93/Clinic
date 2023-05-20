<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 17.05.2023
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Rejestracja</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
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
    <form:form action="/register/add" modelAttribute="registerForm" method="post" class="padding-small text-center">
                    <h1 class="text-color-darker">Rejestracja</h1>
        <br/>
        <form:input path="login" id="login" placeholder="Login"/><br/>
        <form:errors path="login"/>
        <br/>
        <form:input path="email" placeholder="E-mail"/><br/>
        <form:errors path="email"/>
        <br/>
        <form:password path="password" placeholder="Hasło"/><br/>
        <form:errors path="password"/>
        <br/>
        <form:input path="firstName" placeholder="Imię"/><br/>
        <form:errors path="firstName"/>
        <br/>
        <form:input class="register" path="lastName" placeholder="Nazwisko"/><br/>
        <form:errors path="lastName"/>
        <br/>
        <button class="btn btn-color rounded-0" type="submit">Zarejestruj</button>
        <br/>
        <br/>
        <button class="btn btn-color rounded-0" type="reset">Wyczyść</button>

    </form:form>
</div>
<div id="back">
    <a href="/"> <img src="/images/buttonBack.jpg" alt="cofnij" width="250" height="150"></a>
</div>
        </div>
    </div>
</section>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
<jsp:include page="footer.jsp"/>
</body>
</html>