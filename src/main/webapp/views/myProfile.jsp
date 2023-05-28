<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 27.05.2023
  Time: 20:02
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
    <title>Mój profil</title>
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
                <h1> Moje dane: </h1>
                <br/>
                <div id="table">
                    <table>
                        <th>Imię</th>
                        <th>Nazwisko</th>
                        <%--                        <th>Wyświetl kartę</th>--%>
                        <%--                        <th>Dodaj wizytę</th>--%>
                        <%--                        <th>Edytuj</th>--%>
                        <%--                        <th>Usuń</th>--%>

                        <c:forEach items="${profile}" var="prof">
                            <tr>
                                <td>
                                        ${prof.firstName}
                                </td>
                                <td>
                                        ${prof.lastName}
                                </td>
                                    <%--                                <td>--%>
                                    <%--                                    <a href="/patients/card/${patient.id}">wyświetl</a>--%>
                                    <%--                                </td>--%>
                                    <%--                                <td>--%>
                                    <%--                                    <a href="/visit/addVisit/${patient.id}">dodaj</a>--%>
                                    <%--                                </td>--%>
                                    <%--                                <td>--%>
                                    <%--                                    <a href="/patients/edit/${patient.id}">edytuj</a>--%>
                                    <%--                                </td>--%>
                                    <%--                                <td>--%>
                                    <%--                                    <a href="/patients/delete/${patient.id}">usuń</a>--%>
                                    <%--                                </td>--%>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
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
