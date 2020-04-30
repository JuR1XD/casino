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
    <div class="row">
        <c:forEach items="${games}" var="game">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <div class="thumbnail">
                    <div class="caption">
                        <%--<c:if test="${not empty error}">
                            <div class="alert alert-danger">
                                <spring:message code="casino.login.wrongUserCredentials"/>
                            </div>
                        </c:if>--%>
                        <h3>${game.name}</h3>
                        <p>
                            <a href=" <spring:url value="/games/game/${game.gameId}" />" class="btn btn-primary">
                                <span class="glyphicon-play-circle glyphicon"></span> Play
                            </a>
                            <a href="<spring:url value="/games/game/${game.gameId}/test"/>" class="btn btn-primary">
                                <span class="glyphicon-play-circle glyphicon"></span> Test Game for free
                            </a>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</section>
</section>
</body>
</html>
