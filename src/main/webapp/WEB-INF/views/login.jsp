<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Spring Security Tutorial</title>
    <!--<link rel="stylesheet" type="text/css" th:href="@{/css/login.css}"/>-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel-heading">
                <h3 class="panel-title "><spring:message code="casino.account.login.title"/></h3>
            </div>

                <%--<h3 class="form-signin-heading" th:text="Welcome"></h3>--%>
                <br/>
            <c:if test="${not empty error}">
                <div class="alert alert-danger">
                    <spring:message code="casino.login.wrongUserCredentials"/>
                    <br/>
                </div>
            </c:if>
            <form action="<c:url value="/login"/>" method="POST" class="form-signin">
                <input type="text" id="email" name="email"
                       placeholder="<spring:message code="casino.signIn.email"/>"
                       class="form-control"/> <br/>
                <input type="password" placeholder="<spring:message code="casino.signIn.password"/>"
                       id="password" name="password" class="form-control"/> <br/>


                <button class="btn btn-lg btn-primary btn-block" type="submit" value="Login" name="submit">
                    <spring:message
                            code="casino.title.login"/></button>
            </form>
        </div>

    </div>
</div>
</body>
</html>