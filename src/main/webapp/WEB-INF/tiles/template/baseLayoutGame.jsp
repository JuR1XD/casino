<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="bean" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, inital-scale=1.0">
    <title><spring:message code="casino.title.game"/></title>
    <link rel="stylesheet" href="http://getbootstrap.com/dist/css/bootstrap.css">
    <link rel="stylesheet" href="http://getbootstrap.com/examples/jumbotron/jumbotron.css">
</head>
<body>
<div class="container">
    <div class="header">
        <ul class="nav nav-pills pull-right">
            <tiles:insertAttribute name="navigation"/>
        </ul>
        <h3 class="text-muted"><spring:message code="casino"/></h3>
    </div>

    <div class="jumbotron">
        <h1>
            <tilesx:useAttribute name="heading"/>
            <bean:message key="casino.game.title"/>
            <%--<tiles:insertAttribute name="heading"/>--%>
        </h1>
        <p>
            <tilesx:useAttribute name="tagline"/>
            <bean:message key="casino.game.tagline"/>
            <%--<tiles:insertAttribute name="tagline"/>--%>
        </p>
    </div>

    <div class="row">
        <tiles:insertAttribute name="content"/>
    </div>

    <div class="footer">
        <tiles:insertAttribute name="footer"/>
    </div>

</div>
</body>
</html>
