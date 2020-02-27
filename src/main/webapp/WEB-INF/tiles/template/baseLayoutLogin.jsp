<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="bean" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, inital-scale=1.0">
    <title><spring:message code="casino.title.login"/></title>
    <link rel="stylesheet" href="http://getbootstrap.com/dist/css/bootstrap.css">
    <link rel="stylesheet" href="http://getbootstrap.com/examples/jumbotron/jumbotron.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
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
        <a href="<c:url value="/signIn" />" class="btn btn-plain btn-mini pull-right"><bean:message key="casino.login.registration"/></a><form <c:url value="/logout"/> method="get">
        <button class="btn btn-danger btn-mini pull-right" name="registration"
                type="Submit">Logout
        </button>
    </form>
        <h1>
            <tilesx:useAttribute name="heading"/>
            <bean:message key="casino.account.login.title"/>
            <%--<tiles:insertAttribute name="heading"/>--%>
        </h1>
        <p>
            <tilesx:useAttribute name="tagline"/>
            <bean:message key="casino.account.login.tagline"/>
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
