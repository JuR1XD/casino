<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html; charset=ISO-8859-1" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;  ">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1><spring:message code="casino.game.bandid.name"/></h1>
    <p class="pull-right">
    <p><c:if test="${win == true}"><spring:message code="casino.game.win"/></c:if></p>
    <br><br>

    <form:form modelAttribute="getNumbers" method="post">
    <p class="media-middle"><form:input path="numberOne" readonly="true"/><form:input
            path="numberTwo" readonly="true"/><form:input path="numberThree"
                                                          readonly="true"/></p>
    <br><br>
    <div class="form-group">
        <div class="col-lg-offset-2 col-lg-10">
            <input type="submit" id="btnAdd" class="btn btn-primary"
                   value="<spring:message code="casino.game.play"/>"/>
        </div>
    </div>
</div>
</form:form>
</body>
</html>
