<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 22.05.2023
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Mediculum</title>
    <link rel="stylesheet" href='<c:url value="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"/>' integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <link href='<c:url value="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"/>'
          rel="stylesheet">
    <link href='<c:url value="/css/style.css"/>' rel="stylesheet" type="text/css">
    <link rel="stylesheet" href='<c:url value="https://use.fontawesome.com/releases/v5.5.0/css/all.css"/>' integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>

<body>
<jsp:include page="header.jsp"/>

<section class="padding-large bg-light">
<div id="box">
    <c:if test="${not empty loggedUser}">
        <div id="hello">

            <p >Witaj, ${loggedUser.login}</p>
        </div>
<%--        <p id="logout"><a href="/logout"><img src="/images/Log_Out.png"></a></p>--%>
    </c:if>
    <div id="tile">
        <div class="row">
<%--            <div class="column"><a href="/patients/addPatient"><img src="/images/Add_Patient_Main.png" alt="Dodaj pacjenta" width="222px" height="222px" title="Dodaj pacjenta"/></a></div>--%>
<%--            <div class="column"><a href="/patients/allPatients"><img src="/images/Patient_List_Main.png" alt="Lista pacjentów" width="222px" height="222px" title="Lista pacjentów"/></a></div>--%>
        </div>
        <div class="row">
<%--            <div class="column"><a href="/visit/allVisits"><img src="/images/Visit_List_Main.png" alt="Lista wizyt" width="222px" height="222px" title="Lista wizyt"/></a></div>--%>
<%--            <div class="column"><a href="/stats/summary"><img src="/images/Stats_Main.png" alt="Statystyki" width="222px" height="222px" title="Statystyki"/></a></div>--%>
        </div>
    </div>
</div>
</section>

<jsp:include page="footer.jsp"/>
</body>
</html>
