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
    <h2>Your Personal Data</h2>
    <ul>
        <li>${userNamePt2}</li>
        <li>${userEmail}</li>
        <li>${userAddress}</li>
        <li>${userNamePt2}</li>
        <li>${userAddressPt3}</li>
    </ul>
</div>
</body>
</html>
