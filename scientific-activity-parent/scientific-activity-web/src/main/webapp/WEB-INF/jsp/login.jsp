<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>

<%@include file="include/header.jsp" %>
<%@include file="include/menu.jsp" %>



<form method="post" action="${pageContext.request.contextPath}/login">
<table>
    <tr>
        <td><label for="userName">User name</label></td>
        <td><input id="userName" type="text" name="userName"></td>
    </tr>
    <tr>
        <td><label for="password">User name</label></td>
        <td><input id="password" type="password" name="password"></td>
    </tr>
</table>
<jsp:include page="include/footer.jsp"/>
</body>
</html>