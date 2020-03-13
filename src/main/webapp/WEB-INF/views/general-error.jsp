<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=ISO-8859-1" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Welcome</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1><b>401</b> <spring:message code="casino.generalError.title.or"/> <b>404</b> <spring:message code="casino.generalError.title.or"/> <b>503</b><br><%--<spring:message code="casino.generalError.title"/>--%></h1>
            <p><spring:message code="casino.generalError.line"/> </p>
            <p><spring:message code="casino.generalError.tagline"/> <b><a href="<spring:url value="/"/>" style="color: black;"><spring:message code="casino.generalError.tagline.link"/> </a></b></p>
        </div>
    </div>
</section>
</body>
</html>
