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
<form:form modelAttribute="searchTerm" method="post">
    <div class="container" id="nameDiv">
    <form:input id="searchName" cssClass="input-lg" path="searchInput"/>
    <form:errors path="searchInput" cssClass="text-danger"/>
    <button class="btn btn-default" type="submit">Search&nbsp;<span
            class="glyphicon glyphicon-search"></span>
    </button>
    <p><c:if test="${searchTerm != null}"></p>
    <spring:message code="casino.search.results"/>
    <div class="row">
        <c:forEach items="${searchResult}" var="game">
            <a href="<spring:url value="/games/game/${game.gameId}"/>">${game.name}</a>
        </c:forEach>
    </div>
    </div>
    <c:if test="${searchResult == null}">
        <h3><spring:message code="casino.search.notFoundName"/></h3>
    </c:if>
</c:if>
</form:form>



</body>
</html>