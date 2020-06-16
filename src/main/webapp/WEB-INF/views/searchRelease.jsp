<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="string" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>


<p><spring:message code="casino.search.frontpage"/></p>
<form:form modelAttribute="searchTermRelease" method="post">
    <div class="container" id="releaseDiv">
    <form:input id="searchRelease" type="date" path="release"/>
    <form:errors path="release"/>
    <button class="btn btn-default" type="submit" id="releaseBtn">Search&nbsp;<span
            class="glyphicon glyphicon-search"></span>
    </button>
    <p><c:if test="${searchTerm != null}"></p>
    <h2><spring:message code="casino.search.results"/></h2>
    <br>
    <div class="row">
        <c:forEach items="${searchResultRelease}" var="game">
            <a style="color: black;" href="<spring:url value="/games/game/${game.gameId}"/>"><span
                    class="glyphicon glyphicon-arrow-right"></span>&nbsp;&nbsp;${game.name}</a>
            <br><br>
        </c:forEach>
    </div>
    <c:if test="${searchResultRelease == null}">
        <h3><spring:message code="casino.search.notFoundRelease"/></h3>
    </c:if></div>
</c:if>


</form:form>

</body>
</html>