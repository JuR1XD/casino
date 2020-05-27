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
<%--

<p>Search for a Game:</p>
<form:input path="${searchTerm}" cssClass="input-lg"/><input type="submit">

<p><c:if test="${not empty searchTerm}">
    Search Results:
<div class="row">
        <a href="<spring:url value="/games/game/${searchResult.gameId}"/>">${searchResult.name}</a>
</div>
</c:if>
</p>


--%>

</body>
</html>