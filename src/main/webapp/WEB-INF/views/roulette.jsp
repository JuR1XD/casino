<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="string" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html; charset=ISO-8859-1" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>Roulette</h1>

    <p>Bitte geben sie eine nummer zwischen 1 und 35 ein:</p>
    <input type="number" min="1" max="35">
    <br><br>
    <p>Ausgabe:</p>
    <input type="number" min="1" readonly>
    <c:if test="${win == true}">Sie haben gewonnen</c:if>
    <input type="submit" class="btn btn-default" value="Play">
</div>
</body>
</html>
