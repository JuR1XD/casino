<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<li><a href="<spring:url value="/"/>"><spring:message code="navigation.home"/></a></li>
<li><a href="<spring:url value="/games"/>"><spring:message code="navigation.games"/></a></li>
<c:if test="${not empty user}"><li><a href="<spring:url value="/account"/>"><spring:message code="navigation.myAccount"/></a></li></c:if>
<li><a href="<spring:url value="/search"/>"><spring:message code="navigation.search"/></a></li>
<c:if test="${empty user}"><li><a href="<spring:url value="/signIn"/>"><spring:message code="navigation.registration"/></a></li></c:if>
<c:if test="${empty user}"><li><a href="<spring:url value="/login"/>"><spring:message code="navigation.signIn"/></a></li></c:if>
<c:if test="${not empty user}"><li><a href="<spring:url value="/logout"/>"><spring:message code="casino.account.btn.logout"/> </a></li></c:if>
<li><a style="color: black;"><spring:message code="navigation.language"/> </a></li>
<li><a href="?language=de"><spring:message code="language.german"/> </a>
<li><a href="?language=en"><spring:message code="language.english"/></a></li>
<c:if test="${not empty user}"><li><a style="color: black;"><spring:message code="navigation.greetin"/> ${user}</a></li></c:if>
