<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="string" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html; charset=ISO-8859-1" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
<form:form modelAttribute="userAdmin" class="form-horizontal">
    <fieldset>
        <legend>Admin Panel</legend>

        <form:errors path="email" cssClass="alert alert-danger" element="div"/>
        <form:errors path="birthday" cssClass="alert alert-danger" element="div"/>
        <form:errors path="password" cssClass="alert alert-danger" element="div"/>
        <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="name"><spring:message
                    code="casino.signIn.name"/></label>
            <div class="col-lg-10">
                <form:input id="name" path="name" type="text" class="form:input-large" />
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
            <label class="control-label col-lg-2" for="password"><spring:message
                    code="casino.account.data.isActivated"/></label>
            <div class="col-lg-10">
                <form:select id="isActivated" path="isActivated" class="form:input-large">
                    <form:option value="true">Is Activated</form:option>
                    <form:option value="false">Is not Activated</form:option>
                </form:select>
                <form:errors path="isActivated" cssClass="text-danger"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-lg-2" for="password"><spring:message
                    code="casino.account.data.credit"/></label>
            <div class="col-lg-10">
                <form:input id="credit" path="credit" type="number" min="0" step="0.01" max="10" class="form:input-large"/>
                <form:errors path="credit" cssClass="text-danger"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-lg-2" for="password"><spring:message
                    code="casino.account.data.authority"/></label>
            <div class="col-lg-10">
                <form:select id="authorities" path="authority" class="form:input-large">
                    <form:option value="true">Is Activated</form:option>
                    <form:option value="false">Is not Activated</form:option>
                </form:select>
                <form:errors path="authorities" cssClass="text-danger"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
                <input type="submit" id="btnEdit" class="btn btn-primary" value="Edit"/>
            </div>
        </div>

    </fieldset>
</form:form>

</body>
</html>