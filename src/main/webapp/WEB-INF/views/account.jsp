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
    <h1>${userName}</h1>
    <p class="pull-right"><a class="btn btn-default"
                             href="<spring:url value="/account/withCredit"/>"><spring:message
            code="casino.edit.credit.withdraw"/></a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn btn-default"
                                                                               href="<spring:url value="/account/addCredit"/>"><spring:message
            code="casino.edit.credit.add"/> </a>&nbsp;&nbsp;&nbsp;&nbsp;
        <spring:message code="casino.account.data.credit"/>${currentMoney}&nbsp<spring:message
                code="casino.currency.europe"/></p>
    <h2><spring:message code="casino.account.personalData"/></h2>
    <ul>
        <li><spring:message code="casino.account.data.name"/> ${userNamePt2}</li>
        <li><spring:message code="casino.account.data.email"/>${userEmail}</li>
        <li><spring:message code="casino.account.data.birthday"/>${userBirthday}</li>
        <li><spring:message code="casino.account.data.address"/>${userAddress}</li>
        <li><spring:message code="casino.account.data.postalcode"/>${userAddressPt2}</li>
        <li><spring:message code="casino.account.data.city"/>${userAddressPt3}</li>
    </ul>
    <p><a href="<spring:url value="/account/editUser"/>" class="btn btn-default">Edit User</a></p>
    <p><a href="<spring:url value="/account/editPassword"/>" class="btn btn-default">Edit Password</a></p>
</div>
</body>
</html>
