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
    <p class="pull-right">
        <spring:message code="casino.account.data.credit"/>${currentMoney}&nbsp<spring:message
            code="casino.currency.europe"/></p>
    <p><spring:message code="casino.game.roulette.enterANumber"/></p>
    <form:form modelAttribute="playVariablesRoulette">
    <form:input path="userInput" min="0" max="35" type="number"/>
    <form:errors path="userInput" cssClass="text-danger"/>
    <br><br>
    <p><spring:message code="casino.game.roulette.gameOutput"/></p>
    <form:form modelAttribute="getNumber">
    <form:input path="gameInput" readonly="true"/>
    <p><spring:message code="casino.game.setStake"/></p>
    <form:input path="stake" step="0.01" type="number"/>
    <form:errors path="stake" cssClass="text-danger"/>
    <p class="text-danger"><c:if test="${noCredit == true}"><spring:message code="casino.game.error.notEnoughStake"/></c:if></p>
    <p class="text-danger"><c:if test="${numberFormat == true}"><spring:message  code="casino.signIn.notNull"/></c:if></p>
    <p class="text-danger"><c:if test="${toLessCredit == true}"><spring:message code="casino.game.error.notEnoughMin"/></c:if></p>
    <p class="text-danger"><c:if test="${toMuchCredit == true}"><spring:message code="casino.game.error.tooMuchMin"/></c:if></p>
    <p><c:if test="${win == true}"><spring:message code="casino.game.win"/></c:if></p>
    <input type="submit" class="btn btn-default" value="<spring:message code="casino.game.play"/>">
</div>
</form:form>
</form:form>
</body>
</html>