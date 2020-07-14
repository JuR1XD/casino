<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="string" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>


<h1><spring:message code="casino.search.frontpage"/></h1>
<br><br>

<%--<a class="btn btn-default" href="<spring:url value="/search/byName"/>">Search By Name</a>
<br><br>
<a class="btn btn-default" href="<spring:url value="/search/byRelease"/>">Search By Release</a>--%>


<label><spring:message code="casino.search.decide"/>
    <select id="changeAppearance">
        <option value="searchByName"
                <c:if test="${name == true}">selected="selected"</c:if> id="firstOption"><spring:message
                code="casino.search.optionOne"/></option>
        <option value="searchByRelease"
                <c:if test="${release == true}">selected="selected"</c:if> id="secondOption"><spring:message
                code="casino.search.optionTwo"/></option>
    </select>
</label>
<label id="releaseLabel">
    &nbsp;&nbsp;<spring:message code="casino.search.searchTypeSelect"/>
    <select id="releaseAppearance">
        <option value="single"
                <c:if test="${single == true}">selected="selected"</c:if> id="singleRelease"><spring:message code="casino.search.single"/>
        </option>
        <option value="after"
                <c:if test="${after == true}">selected="selected"</c:if> id="releaseAfter"><spring:message code="casino.search.after"/>
        </option>
        <option value="before"
                <c:if test="${before == true}">selected="selected"</c:if> id="releaseBefore"><spring:message code="casino.search.before"/>
        </option>
        <option value="afterNow"
                <c:if test="${afterNow == true}">selected="selected"</c:if> id="releaseAfterNow"><spring:message code="casino.search.afterNow"/>
        </option>
        <option value="beforeNow"
                <c:if test="${beforeNow == true}">selected="selected"</c:if> id="releaseBeforeNow"><spring:message code="casino.search.beforeNow"/>
        </option>
        <option value="between"
                <c:if test="${between == true}">selected="selected"</c:if> id="releaseBetween"><spring:message code="casino.search.between"/>
        </option>
    </select>
</label>
<br><br>

<form:form modelAttribute="searchTerm" method="post">
    <div class="container" id="nameDiv">
    <form:input id="searchName" cssClass="input-lg" path="searchInput"/>
    <form:errors path="searchInput" cssClass="text-danger"/>
    <p class="text text-danger"><c:if test="${errorsName == true}"><spring:message code="casino.signIn.notNull"/></c:if></p>
    <button class="btn btn-default" id="submitBtn" type="submit">Search&nbsp;<span
            class="glyphicon glyphicon-search"></span>
    </button>
    <p><c:if test="${searchTerm != null && searchTerm != decoy}"></p>
    <h2><spring:message code="casino.search.results"/></h2>
    <div class="row">
        <c:forEach items="${searchResult}" var="game">
            <p><a style="color: black;" href="<spring:url value="/games/game/${game.gameId}"/>"><span
                    class="glyphicon glyphicon-arrow-right"></span>&nbsp;&nbsp;${game.name}</a></p>
        </c:forEach>
    </div>
    </div>
    <c:if test="${searchResult == null}">
        <h3 id="notFoundName"><spring:message code="casino.search.notFoundName"/></h3>
    </c:if>
</c:if>

    <div class="container" id="releaseDiv">


    <form:input id="searchReleaseInput" type="date" path="release"/>
    <form:errors path="release"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <form:input id="secondDateInput" path="secondDate" type="date"/>
    <form:errors path="secondDate"/>
    <p class="text text-danger"><c:if test="${errorsRelease == true}"><spring:message code="casino.signIn.notNull"/></c:if></p>
    <button class="btn btn-default" type="submit" id="releaseBtn">Search&nbsp;<span
            class="glyphicon glyphicon-search"></span>
    </button>
    <p><c:if test="${searchTerm != null && searchTerm != otherDecoy}"></p>
    <h2><spring:message code="casino.search.results"/></h2>
    <br>
    <div class="row">
        <c:forEach items="${searchResultRelease}" var="game">
            <p><a style="color: black;" href="<spring:url value="/games/game/${game.gameId}"/>"><span
                    class="glyphicon glyphicon-arrow-right"></span>&nbsp;&nbsp;${game.name}</a></p>
        </c:forEach>
    </div>
    <c:if test="${searchResultRelease == null}">
        <h3 id="notFoundRelease"><spring:message code="casino.search.notFoundRelease"/></h3>
    </c:if></div>
</c:if>
</form:form>


<script>
    const searchName = $("#searchName");
    const searchRelease = $("#searchReleaseInput");
    const searchSecondRelease = $("#secondDateInput");
    const firstSelect = $("#changeAppearance");
    const secondSelect = $("#releaseAppearance");
    console.log(searchName, searchRelease, searchSecondRelease, firstSelect, secondSelect);


    $(secondSelect).change(function () {
        if($(this).val() === "single")
        {
            $(searchName).val("-");
            $(searchSecondRelease).hide().val("1600-01-01");
        }
        else if($(this).val() === "after")
        {
            $(searchName).val("-.");
            $(searchSecondRelease).hide().val("1600-01-01");
        }
        else if($(this).val() === "before")
        {
            console.log(searchName, searchRelease, searchSecondRelease, firstSelect, secondSelect);
            $(searchName).val(".-");
            $(searchSecondRelease).hide().val("1600-01-01");
        }
        else if($(this).val() === "afterNow")
        {
            $(searchName).val("--");
            $(searchSecondRelease).hide().val("1600-01-01");
        }
        else if($(this).val() === "beforeNow")
        {
            $(searchName).val("--.");
            $(searchSecondRelease).hide().val("1600-01-01");
        }
        else
        {
            console.log(searchName, searchRelease, searchSecondRelease, firstSelect, secondSelect);
            $(searchName).val("--.-");
            $(searchSecondRelease).show().val("");
        }

        console.log(searchName, searchRelease, searchSecondRelease, firstSelect, secondSelect);

    }).trigger("change");

    $(firstSelect).change(function () {
        if ($(this).val() === "searchByName"
        ) {
            $("#releaseDiv").hide();
            $("#nameDiv").show();
            $("#notFoundRelease").hide();
            $(secondSelect).hide().val("searchBySingleRelease");
            $("#notFoundName").show();
            $(searchRelease).val("1600-01-01");
            $("#secondDateInput").val("1600-01-01");
            $(searchName).val("");
            $("#releaseLabel").hide();

        } else if($(this).val() === "searchByRelease"){

            $("#releaseDiv").show();
            $("#nameDiv").hide();
            $("#notFoundRelease").show();
            $("#notFoundName").hide();
            $(searchRelease).val("");
            $(searchSecondRelease).hide();
            $("#releaseAppearance").show();
            $("#releaseLabel").show();
        }
        /*switch ($(secondSelect)) {
            case "single":
                $(searchName).val("-");
                $(searchSecondRelease).hide().val("1600-01-02");
                break;
            case "after":
                $(searchName).val("-.");
                $(searchSecondRelease).hide().val("1600-01-03");
                break;
            case "before":
                console.log(searchName, searchRelease, searchSecondRelease, firstSelect, secondSelect);
                $(searchName).val(".-");
                $(searchSecondRelease).hide().val("1600-01-04");
                break;
            case "afterNow":
                $(searchName).val("--");
                $(searchSecondRelease).hide().val("1600-01-01");
                break;
            case "beforeNow":
                $(searchName).val("--.");
                $(searchSecondRelease).hide().val("1600-01-01");
                break;
            case "between":
                console.log(searchName, searchRelease, searchSecondRelease, firstSelect, secondSelect);
                $(searchName).val("--.-");
                $(searchSecondRelease).show().val("");
                break;
        }*/
/*        if($(secondSelect) === "single")
        {
            $(searchName).val("-");
            $(searchSecondRelease).hide().val("1600-01-02");
        }
        else if($(secondSelect) === "after")
        {
            $(searchName).val("-.");
            $(searchSecondRelease).hide().val("1600-01-03");
        }
        else if($(secondSelect) === "before")
        {
            console.log(searchName, searchRelease, searchSecondRelease, firstSelect, secondSelect);
            $(searchName).val(".-");
            $(searchSecondRelease).hide().val("1600-01-04");
        }
        else if($(secondSelect) === "afterNow")
        {
            $(searchName).val("--");
            $(searchSecondRelease).hide().val("1600-01-01");
        }
        else if($(secondSelect) === "beforeNow")
        {
            $(searchName).val("--.");
            $(searchSecondRelease).hide().val("1600-01-01");
        }
        else if($(secondSelect) === "between")
        {
            console.log(searchName, searchRelease, searchSecondRelease, firstSelect, secondSelect);
            $(searchName).val("--.-");
            $(searchSecondRelease).show().val("");
        }*/

        console.log(searchName, searchRelease, searchSecondRelease, firstSelect, secondSelect);
    })
        .trigger("change");

        /*$(secondSelect).change(function () {
            switch ($(this)) {
                case "single":
                    $(searchName).val("-");
                    $(searchSecondRelease).hide().val("1600-01-02");
                    break;
                case "after":
                    $(searchName).val("-.");
                    $(searchSecondRelease).hide().val("1600-01-03");
                    break;
                case "before":
                    $(searchName).val(".-");
                    $(searchSecondRelease).hide().val("1600-01-04");
                    break;
                case "afterNow":
                    $(searchName).val("--");
                    $(searchSecondRelease).hide().val("1600-01-01");
                    break;
                case "beforeNow":
                    $(searchName).val("--.");
                    $(searchSecondRelease).hide().val("1600-01-01");
                    break;
                case "between":
                    $(searchName).val("--.-");
                    $(searchSecondRelease).show().val("");
                    break;
            }
            console.log(searchName, searchRelease, searchSecondRelease, firstSelect, secondSelect);
        }).trigger("change");*/


</script>

</body>
</html>