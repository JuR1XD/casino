<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
            <h1><b>403</b> That's strange.... </h1>
            <b><p>You don't have the permission the get access to this site. <p>Contact your admin or just leave it.</p></b>
            <p>You've found a page that you shouldn't find</p>
            <p>Just return back to our home page <b><a href="<spring:url value="/"/>" class="btn btn-plain" style="color: black;">here</a></b></p>
        </div>
    </div>
</section>

<div>
    <p></p>
</div>
</body>
</html>
