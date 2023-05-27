<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 27.05.2023
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Dodawanie nowego pacjenta</title>
    <link rel="stylesheet" href='<c:url value="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"/>' integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <link href='<c:url value="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"/>'
          rel="stylesheet">
    <link href='<c:url value="/css/style.css"/>' rel="stylesheet" type="text/css">
    <link rel="stylesheet" href='<c:url value="https://use.fontawesome.com/releases/v5.5.0/css/all.css"/>' integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>

<body>
<header class="page-header">
    <jsp:include page="headerLogged.jsp"/>
</header>


<section class="dashboard-section">
    <div class="row dashboard-nowrap">
        <jsp:include page="dashboard.jsp"/>
            <div id="patient">
                <div id="data">
                    <h1> Dodawanie nowego pacjenta </h1>
                    <br/>
                    <h4> Dane kontaktowe: </h4>
                    <br/>
                    <form:form modelAttribute="patientForm" method="post">

                    <form:input class="form-control" path="pesel" placeholder="Pesel"/><br/>
                    <form:errors path="pesel"/>
                    <br/>
                    <form:input class="form-control" path="firstName" placeholder="Imię"/><br/>
                    <form:errors path="firstName"/>
                    <br/>
                    <form:input class="form-control" path="lastName" placeholder="Nazwisko"/><br/>
                    <form:errors path="lastName"/>
                    <br/>
                    <form:input class="form-control" path="address" placeholder="Ulica"/><br/>
                    <form:errors path="address"/>
                    <br/>
                    <form:input class="form-control" path="houseNumber" placeholder="Numer domu"/><br/>
                    <form:errors path="houseNumber"/>
                    <br/>
                    <form:input class="form-control" path="apartmentNumber" placeholder="Numer mieszkania"/><br/>
                    <form:errors path="apartmentNumber"/>
                    <br/>
                    <form:input class="form-control" path="phone" placeholder="Numer telefonu"/><br/>
                    <form:errors path="phone"/>
                    <br/>
                    <form:input class="form-control" path="email" placeholder="E-mail"/><br/>
                    <form:errors path="email"/>
                    <br/>
                    <br/>
                </div>
<%--                <div id="card">--%>
<%--                    <h4>Karta badania:</h4>--%>
<%--                    <br/>--%>
<%--                    <form:input class="add" path="diagnosis" placeholder="Rozpoznanie"/><br/>--%>
<%--                    <form:errors path="diagnosis"/>--%>
<%--                    <br/>--%>
<%--                    <form:input class="add" path="symptoms" placeholder="Objawy"/><br/>--%>
<%--                    <form:errors path="symptoms"/>--%>
<%--                    <br/>--%>
<%--                    <form:input class="add" path="diseases" placeholder="Choroby współistniejące"/><br/>--%>
<%--                    <form:errors path="diseases"/>--%>
<%--                    <br/>--%>
<%--                    <form:input class="add" path="functioning" placeholder="Funkcjonowanie"/><br/>--%>
<%--                    <form:errors path="functioning"/>--%>
<%--                    <br/>--%>
<%--                    <form:input class="add" path="activity" placeholder="Aktywność fizyczna"/><br/>--%>
<%--                    <form:errors path="activity"/>--%>
<%--                    <br/>--%>
<%--                    <form:input class="add" path="rehab" placeholder="Dotychczasowa rehabilitacja"/><br/>--%>
<%--                    <form:errors path="rehab"/>--%>
<%--                    <br/>--%>
<%--                    <form:input class="add" path="medicines" placeholder="Leki"/><br/>--%>
<%--                    <form:errors path="medicines"/>--%>
<%--                    <br/>--%>
<%--                    <form:input class="add" path="procedures" placeholder="Zabiegi operacyjne, urazy"/><br/>--%>
<%--                    <form:errors path="procedures"/>--%>
<%--                    <br/>--%>
<%--                    <form:input class="add" path="drugs" placeholder="Używki"/><br/>--%>
<%--                    <form:errors path="drugs"/>--%>
<%--                    <br/>--%>
<%--                    <form:textarea class="add" path="exam" placeholder="Badanie"/><br/>--%>
<%--                    <form:errors path="exam"/>--%>
                    <br/>
                    <br/>
                    <input type="submit" id="confirm" value="Dodaj"/>
                    <input type="reset" id="clear" value="Wyczyść"/>
                    </form:form>
<%--                </div>--%>
            </div>
            <br/>
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