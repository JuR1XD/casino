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
    <h1>Blackjack</h1>
    <p class="pull-right">
        <spring:message code="casino.account.data.credit"/>${currentMoney}&nbsp<spring:message
            code="casino.currency.europe"/></p>
    <form:form modelAttribute="getCards">
    <p><spring:message code="casino.game.blackjack.cardsOfDealer"/> </p>
    <p><form:input path="cardEnemyOne" readonly="true"/><form:input path="cardEnemyTwo" readonly="true"/></p>
    <br><br>
    <p><spring:message code="casino.game.blackjack.cardsOfPlayer"/></p>
    <p><form:input path="cardUserOne" readonly="true"/><form:input path="cardUserTwo" readonly="true"/></p>
    <br><br><br>
    <p><c:if test="${win == true}"><spring:message code="casino.game.win"/></c:if></p>
    <p><c:if test="${toLessCredit == true}"><spring:message code="casino.game.error.notEnoughMin"/></c:if></p>
    <p><c:if test="${noCredit == true}"><spring:message code="casino.game.error.notEnoughStake"/></c:if></p>
    <br>
    <form:form modelAttribute="playVariablesBlackjack" method="post">
    <p class="text-danger"><spring:message code="casino.game.setStake"/><form:input path="stake" step="0.01" type="number" min="${min}"/></p>
    <p><form:errors path="stake" cssClass="text-danger"/></p>
    <br>
    <input type="submit" class="btn btn-default" value="<spring:message code="casino.game.play"/>">
</div>
</form:form>
</form:form>
</body>
</html>
