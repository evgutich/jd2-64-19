<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<html lang="${param.lang}">
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="home.page.title"/></title>
</head>
<body>

<%@include file="include/header.jsp" %>
<%@include file="include/menu.jsp" %>

<h3><fmt:message key="home.page.header"/></h3>

<fmt:message key="home.page.text"/>

<ul>
    <li>Login</li>
    <li>Publication List</li>
    <li>Add new Publication</li>
    <li>
        Localization:
        <a href="?lang=en">en</a> |
        <a href="?lang=ru">ru</a>
    </li>
</ul>

<jsp:include page="include/footer.jsp"/>

</body>
</html>