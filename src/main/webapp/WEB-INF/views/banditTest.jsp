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
        <spring:message code="casino.account.data.credit"/>${currentMoney}&nbsp<spring:message
            code="casino.currency.europe"/></p>
    <p><c:if test="${noCredit == true}"><spring:message code="casino.game.error.notEnoughStake"/></c:if></p>
    <p><c:if test="${toLessCredit == true}"><spring:message code="casino.game.error.notEnoughMin"/></c:if></p>
    <p><c:if test="${win == true}"><spring:message code="casino.game.win"/></c:if></p>
    <br><br>

    <form:form modelAttribute="getNumbers" method="post">
    <p class="media-middle"><form:input path="numberOne" readonly="true"/><form:input
            path="numberTwo" readonly="true"/><form:input path="numberThree"
                                                          readonly="true"/></p>
    <br><br>
    <form:form modelAttribute="playVariablesBandit" class="form-horizontal" method="post">

    <div class="form-group">
        <label class="control-label col-lg-2 col-lg-2" for="stake"><spring:message
                code="casino.game.setStake"/></label>
        <div class="col-lg-10">
            <form:input id="stake" type="number" step="0.01" path="stake"/>
            <form:errors path="stake" cssClass="text-danger"/>
        </div>
    </div>
    <br><br>
    </p>
    <div class="form-group">
        <div class="col-lg-offset-2 col-lg-10">
            <input type="submit" id="btnAdd" class="btn btn-primary" value="<spring:message code="casino.game.play"/>"/>
        </div>
    </div>
</div>
</form:form>
</form:form>
</body>
</html>
