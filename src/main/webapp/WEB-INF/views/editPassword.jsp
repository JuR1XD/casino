<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <form:form modelAttribute="passwordEdit" class="form-horizontal" method="post">
        <fieldset>
            <legend>Sign In</legend>
            <form:errors path="*" cssClass="alert alert-danger" element="div"/>
                <%--<form:errors path="password" cssClass="alert alert-danger" element="div"/>
                            <form:errors path="matchingPassword" cssClass="alert alert-danger" element="div"/>--%>
            <c:if test="${not empty error}">
                <div class="alert alert-danger">
                    <spring:message code="casino.signIn.passwordMatch.error"/>
                </div>
            </c:if>
            <div class="form-group">
                <label class="control-label col-lg-2" for="password"><spring:message
                        code="casino.signIn.oldPassword"/></label>
                <div class="col-lg-10">
                    <form:input id="oldPassword" path="oldPassword" type="password" class="form-control"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="password"><spring:message
                        code="casino.signIn.password"/></label>
                <div class="col-lg-10">
                    <form:input id="password" path="password" type="password" class="form-control"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="matchingPassword"><spring:message
                        code="casino.signIn.matchingPassword"/></label>
                <div class="col-lg-10">
                    <form:input id="matchingPassword" path="matchingPassword" type="password"
                                class="form-control"/>
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
