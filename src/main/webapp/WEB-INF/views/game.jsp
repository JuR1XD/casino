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
    <title>Welcome</title>
</head>
<body>
<section class="container">
    <div class="col-md-5">
        <h3>${game.name}</h3>
        <p>${game.description}</p>
        <p>
            <strong>Mindesteinsatz:</strong> ${game.min} <spring:message code="casino.currency.europe"/>
        </p>
        <p>
            <strong>Ist Aktiviert:</strong> ${isActivatedText}
        </p>
        <p>
            <c:if test="${error}">
        <div class="alert alert-danger">
            <spring:message code="casino.game.isNotActivated"/>
        </div>
            </c:if>
        <c:if test="${isActivated}">
            <a href=" <spring:url value="/games/game/${game.gameId}/play" />" class="btn btn-primary">
                <span class="glyphicon-play-circle glyphicon"></span> Play
            </a></c:if>
    </div>
</section>
</body>
</html>