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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<section class="container">
    <form:form modelAttribute="user" class="form-horizontal">
    <fieldset>
        <legend>Sign In</legend>

        <form:errors path="email" cssClass="alert alert-danger" element="div"/>
        <form:errors path="birthday" cssClass="alert alert-danger" element="div"/>
        <form:errors path="password" cssClass="alert alert-danger" element="div"/>
        <form:errors path="matchingPassword" cssClass="alert alert-danger" element="div"/>
        <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="name"><spring:message
                    code="casino.signIn.name"/></label>
            <div class="col-lg-10">
                <form:input id="nameText" path="name" type="text" class="form:input-large" />
                <p class="text text-danger" id="nameWarning"><spring:message code="casino.signIn.notNull"/></p>
                <form:errors path="name" cssClass="text-danger"/>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2" for="surname"><spring:message
                    code="casino.signIn.surname"/></label>
            <div class="col-lg-10">
                <form:input id="surname" path="surname" type="text" class="form:input-large"/>
                <form:errors path="surname" cssClass="text-danger"/>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2" for="birthday"><spring:message
                    code="casino.signIn.birthday"/></label>
            <div class="col-lg-10">
                <div class="form:input-prepend">
                    <form:input id="birthday" path="birthday" type="date"  class="form:input-large"/>
                    <form:errors path="birthday" cssClass="text-danger"/>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2" for="email"><spring:message
                    code="casino.signIn.email"/></label>
            <div class="col-lg-10">
                <form:input id="email" path="email" type="text" class="form:input-large"/>
                <form:errors path="email" cssClass="text-danger"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-lg-2" for="street"><spring:message
                    code="casino.signIn.street"/></label>
            <div class="col-lg-10">
                <form:input id="street" path="street" type="text" class="form:input-large"/>
                <form:errors path="street" cssClass="text-danger"/>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2" for="streetNr"><spring:message
                    code="casino.signIn.streetNr"/></label>
            <div class="col-lg-10">
                <form:input id="streetNr" path="streetNr" type="text" class="form:input-large"/>
                <form:errors path="streetNr" cssClass="text-danger"/>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2" for="postalCode"><spring:message
                    code="casino.signIn.postalCode"/></label>
            <div class="col-lg-10">
                <form:input id="postalCode" path="postalCode" type="text" class="form:input-large"/>
                <form:errors path="postalCode" cssClass="text-danger"/>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2" for="city"><spring:message
                    code="casino.signIn.city"/></label>
            <div class="col-lg-10">
                <form:input id="city" path="city" type="text" class="form:input-large"/>
                <form:errors path="city" cssClass="text-danger"/>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2" for="password"><spring:message
                    code="casino.signIn.password"/></label>
            <div class="col-lg-10">
                <form:input id="password" path="password" type="password" class="form:input-large"/>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2" for="matchingPassword"><spring:message
                    code="casino.signIn.matchingPassword"/></label>
            <div class="col-lg-10">
                <form:input id="matchingPassword" path="matchingPassword" type="password" class="form:input-large"/>
                <form:errors path="matchingPassword" cssClass="text-danger"/>
            </div>
        </div>

        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
                <input type="submit" id="btnAdd" class="btn btn-primary" value="Add"/>
            </div>
        </div>

    </fieldset>
    </form:form>
<script>

    $("#nameWarning").change(function()
    {
        if ($("#nameText") === "")
        {
            $("#nameWarning").show();
        }
        else
        {
            $("#nameWarning").hide();
        }
    }).trigger("change");
</script>

</section>
</body>
</html>
