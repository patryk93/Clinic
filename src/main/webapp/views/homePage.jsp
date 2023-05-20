<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 16.05.2023
  Time: 17:51
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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"
          rel="stylesheet">
    <link href='<c:url value="/css/style.css"/>' rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>

<body>
<jsp:include page="header.jsp"/>

<section class="padding-large bg-light">
    <div id="carouselExampleControls" class="carousel slide main-slider" data-ride="carousel">
        <div class="carousel-inner container">
            <div class="carousel-item active">
                <div class="container w-75 d-flex">
                    <div class="carousel-caption d-block">
                        <img src="<c:url value="https://www.zdrowiekoluszki.pl/images/slajdy/_DSC3878.jpg"/>"/>
                    </div>
                </div>
            </div>
<%--            <div class="carousel-item">--%>
<%--                <div class="container w-75 d-flex">--%>
<%--                    <div class="carousel-caption d-block">--%>

<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="carousel-item">--%>
<%--                <div class="container w-75 d-flex">--%>
<%--                    <div class="carousel-caption d-block">--%>

<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</section>

<jsp:include page="footer.jsp"/>

</body>
</html>