<%@ taglib prefix="string" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=ISO-8859-1" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
<section class="container">
    <form:form modelAttribute="user" class="form-horizontal">
        <fieldset>
            <legend>Sign In</legend>
            <div class="form-group">
                <label class="control-label col-lg-2" for="credit"><spring:message
                        code="casino.signIn.matchingPassword"/></label>
                <div class="col-lg-10">
                    <form:input id="credit" path="credit" type="password" class="form:input-large"/>
                    <form:errors path="credit" cssClass="text-danger"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input type="submit" id="btnAdd" class="btn btn-primary" value="Add"/>
                </div>
            </div>

        </fieldset>
    </form:form>


</section>
</body>
</html>
