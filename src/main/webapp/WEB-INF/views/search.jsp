<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="string" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>


<h1><spring:message code="casino.search.frontpage"/></h1>
<br><br>

<%--<a class="btn btn-default" href="<spring:url value="/search/byName"/>">Search By Name</a>
<br><br>
<a class="btn btn-default" href="<spring:url value="/search/byRelease"/>">Search By Release</a>--%>


    <label><spring:message code="casino.search.decide"/>
        <select id="changeAppearance">
            <option value="searchByName" <c:if test="${name == true}">selected="selected"</c:if> id="firstOption"><spring:message code="casino.search.optionOne"/></option>
            <option value="searchByRelease" <c:if test="${release == true}">selected="selected"</c:if> id="secondOption"><spring:message code="casino.search.optionTwo"/></option>
        </select>
    </label>
    <br><br>

<form:form modelAttribute="searchTerm" method="post">
    <div class="container" id="nameDiv">
    <form:input id="searchName" cssClass="input-lg" path="searchInput"/>
    <form:errors path="searchInput" cssClass="text-danger"/>
    <button class="btn btn-default" id="submitBtn" type="submit">Search&nbsp;<span
            class="glyphicon glyphicon-search"></span>
    </button>
    <p><c:if test="${searchTerm != null && searchTerm != decoy}"></p>
    <h2><spring:message code="casino.search.results"/></h2>
    <div class="row">
        <c:forEach items="${searchResult}" var="game">
            <p><a style="color: black;" href="<spring:url value="/games/game/${game.gameId}"/>"><span
                    class="glyphicon glyphicon-arrow-right"></span>&nbsp;&nbsp;${game.name}</a></p>
        </c:forEach>
    </div>
    </div>
    <c:if test="${searchResult == null}">
        <h3 id="notFoundName"><spring:message code="casino.search.notFoundName"/></h3>
    </c:if>
</c:if>

    <div class="container" id="releaseDiv">
    <form:input id="searchReleaseInput" type="date" path="release"/>
    <form:errors path="release"/>
    <button class="btn btn-default" type="submit" id="releaseBtn">Search&nbsp;<span
            class="glyphicon glyphicon-search"></span>
    </button>
    <p><c:if test="${searchTerm != null && searchTerm != otherDecoy}"></p>
    <h2><spring:message code="casino.search.results"/></h2>
    <br>
    <div class="row">
        <c:forEach items="${searchResultRelease}" var="game">
            <p><a style="color: black;" href="<spring:url value="/games/game/${game.gameId}"/>"><span
                    class="glyphicon glyphicon-arrow-right"></span>&nbsp;&nbsp;${game.name}</a></p>
        </c:forEach>
    </div>
    <c:if test="${searchResultRelease == null}">
        <h3 id="notFoundRelease"><spring:message code="casino.search.notFoundRelease"/></h3>
    </c:if></div>
</c:if>
</form:form>



<script>
    $("#searchReleaseInput").val("1600-01-01");
        $("#changeAppearance").change(function () {
            if ($(this).val() === "searchByName"
            ) {
                $("#releaseDiv").hide();
                $("#nameDiv").show();
                $("#notFoundRelease").hide();
                $("#notFoundName").show();
                $("#searchReleaseInput").val("1600-01-01");
                $("#searchName").val("");

            } else {
                $("#releaseDiv").show();
                $("#nameDiv").hide();
                $("#notFoundRelease").show();
                $("#notFoundName").hide();
                $("#searchReleaseInput").val("");
                $("#searchName").val("-");
            }
        })
            .trigger("change");

    </script>

</body>
</html>