<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="bean" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, inital-scale=1.0">
    <title><tiles:insertAttribute name="title"/> </title>
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
            <tiles:useAttribute name="heading"/>
            <bean:message key="casino.games.title"/>
            <%--<tiles:insertAttribute name="heading"/>--%>
        </h1>
        <p>
            <tiles:useAttribute name="tagline"/>
            <bean:message key="casino.games.tagline"/>
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
